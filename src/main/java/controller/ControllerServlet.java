package controller;

import java.io.IOException;
import java.util.List;

import dao.IProductDao;
import dao.ProductDaoImpl;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ProductModel;

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
		String path = req.getServletPath();	//HTTP root path
		req.setAttribute("currentPath", path);
		if (path.equals("/index.do")) {
			req.getRequestDispatcher(pathViews+"/products.jsp").forward(req, resp);
		}
		else if (path.equals("/search.do")) {
			String keyword = req.getParameter("keyword");
			ProductModel pm = new ProductModel();
			pm.setKeyword(keyword);
			List<Product> prods = pr.getProductsByKeyword(keyword);
			pm.setP(prods);
			req.setAttribute("model", pm);
			req.getRequestDispatcher(pathViews+"/products.jsp").forward(req, resp);
		}else if(path.equals("/addProduct.do")){
			
			req.getRequestDispatcher(pathViews+"/addProduct.jsp").forward(req, resp);
			
		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"The requested resource was not found.");
		}
		
	}
	
}
