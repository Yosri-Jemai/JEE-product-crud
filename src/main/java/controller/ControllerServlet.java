package controller;

import java.io.IOException;
import java.util.List;

import dao.IProductDao;
import dao.ProductDaoImpl;
import entities.Product;
import model.ProductModel;
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
		String path = req.getServletPath();	
		req.setAttribute("currentPath", path); //needed for view/header.jsp
		if (path.equals("/home.do")) {
			String keyword = req.getParameter("keyword");
			ProductModel pm = new ProductModel();
			List<Product> prods = pr.getProductsByKeyword(keyword);
			pm.setP(prods);
			req.setAttribute("model", pm);
			req.getRequestDispatcher(pathViews+"/products.jsp").forward(req, resp);
		}else if(path.equals("/save.do")){
			req.getRequestDispatcher(pathViews+"/addProduct.jsp").forward(req, resp); 
		} else if(path.equals("/delete.do")){
			long id = Long.parseLong(req.getParameter("id"));
			pr.deleteProduct(id);
			resp.sendRedirect("home.do?keyword=");
		} else if(path.equals("/edit.do")){
			long id = Long.parseLong(req.getParameter("id"));
			Product p = pr.getProduct(id);
			req.setAttribute("product", p);
			req.getRequestDispatcher(pathViews+"/editProduct.jsp").forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"The requested resource was not found.");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("_method");
	    if ("patch".equalsIgnoreCase(method)) {
	        doPatch(req, resp);
	        return;
	    }
		
		String path = req.getServletPath();	
		req.setAttribute("currentPath", path); 
		if(path.equals("/confirmation.do")){
		String designation = req.getParameter("designation");
		double price = Double.parseDouble(req.getParameter("price"));
		long quantity = Long.parseLong(req.getParameter("quantity"));
		Product p = pr.addProduct(new Product(designation,price,quantity));
		req.setAttribute("newProduct", p);
		req.getRequestDispatcher(pathViews + "/confirm.jsp").forward(req, resp);
		// To fix => Post/Redirect/Get pattern (data resent on refresh)
		}
	}
	
	@Override
	protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    long id = Long.parseLong(req.getParameter("id"));
	    String designation = req.getParameter("designation");
	    double price = Double.parseDouble(req.getParameter("price"));
	    long quantity = Long.parseLong(req.getParameter("quantity"));

	    Product p = new Product(designation, price, quantity);
	    p.setId(id);
	    
	    pr.updateProduct(p);

	    req.setAttribute("newProduct", p);
	       
	    req.getRequestDispatcher(pathViews + "/confirm.jsp").forward(req, resp);

	}
	
	
}
