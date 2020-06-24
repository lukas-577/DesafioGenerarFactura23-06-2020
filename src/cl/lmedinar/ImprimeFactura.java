package cl.lmedinar;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imprimeFactura")
public class ImprimeFactura extends HttpServlet{

	
	private static final long serialVersionUID = 6741470868673385758L;
	
	private static final Logger miLog = Logger.getLogger(ImprimeFactura.class.getName());

	
	
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		miLog.info("Se ha ejecutado Servlet ImprimeFactura");
		req.getRequestDispatcher("/factura.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	
	

}
