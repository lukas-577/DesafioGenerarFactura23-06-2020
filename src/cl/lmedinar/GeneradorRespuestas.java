package cl.lmedinar;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/generadorRespuestas")
public class GeneradorRespuestas extends HttpServlet {


	private static final long serialVersionUID = 256397906745485617L;
	private static final Logger miLog = Logger.getLogger(GeneradorRespuestas.class.getName());
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	
	
	String nombre;
	String empresa;
	String rut;
	String direccion,ciudad,pais;
	
	
	//precios de productos
	int valorTotal;
	
	int precioValvulas 	= 120000;
	int precioTurbo 	= 1700000;
	int precioFrenos 	= 760000;
	int precioRefri 	= 2300000;
	int precioPlumas 	= 10000;
	
	
	// Cantidades que cliente solicita de cada producto
	String cantValvulas = req.getParameter("valvulas");
	String cantTurbo 	= req.getParameter("turbo");
	String cantFrenos 	= req.getParameter("frenos");
	String cantRefri 	= req.getParameter("refri");
	String cantPlumas 	= req.getParameter("plumas");
	
	// Total en dinero de cada producto
	Integer totalValvulas 	= precioValvulas * Integer.parseInt(cantValvulas);
	Integer totalTurbo 		= precioTurbo * Integer.parseInt(cantTurbo);
	Integer totalFrenos 	= precioFrenos * Integer.parseInt(cantFrenos);
	Integer totalRefri 		= precioRefri * Integer.parseInt(cantRefri);
	Integer totalPlumas 	= precioPlumas * Integer.parseInt(cantPlumas);
	
	// Se crea Lista con totales de cada producto
	
	Integer totales[] = new Integer[]{totalValvulas,totalTurbo ,totalFrenos, totalRefri, totalPlumas};
    List<Integer> listaTotales = Arrays.asList(totales);
    
    // Se instancia objeto para poder formatear numeros con separacion de miles
    DecimalFormat formatea = new DecimalFormat("###,###.##"); 
    
    //Se calcula el total de todos los productos
    Integer totalFinal = listaTotales.stream().mapToInt(x -> x).sum();
    
    // calculo de total con descuento
    Integer totalConDescuento = (int) (totalFinal*0.90);
    
    // Lista con totales formateados con separacion de miles 
    List<String> listaTotalesFormateados = listaTotales.stream().map(total->formatea.format(total)).collect(Collectors.toList());       

    req.getServletContext().getRequestDispatcher("/imprimeFactura").forward(req, resp);
	
	
	
	
	
	}

}
