package controller;

import java.io.IOException;

import dao.IProductDao;
import dao.ProductDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String pathViews;
	private IProductDao pr;
	
	@Override
	public void init() throws ServletException {
		pathViews = getInitParameter("pathViews");
		pr = new ProductDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(pathViews+"/products.jsp").forward(req, resp);
	}
	
}
