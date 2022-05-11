package vn.liquor.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CategoryModel;
import vn.liquor.model.ProductModel;
import vn.liquor.service.CategoryService;
import vn.liquor.service.ProductService;
import vn.liquor.service.impl.CategoryServiceImpl;
import vn.liquor.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8545562062832729940L;
	ProductService productservice = new ProductServiceImpl();
	CategoryService categoryservice = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    String cid = req.getParameter("cid");
	    String txtSearch = req.getParameter("txt");
	    //Khởi tạo các biến
	    List<ProductModel> listall = productservice.getallproduct();
	    List<ProductModel> gettop1 = productservice.gettop1product();
	    List<CategoryModel> listallcate = categoryservice.getallCate();
	    List<ProductModel> searchbynamepro = productservice.SearchByProductName(txtSearch);
	    req.setAttribute("listall", searchbynamepro);
	    req.setAttribute("listall", searchbynamepro);
	   req.setAttribute("listallcate", listallcate);  
	    req.setAttribute("txtS", txtSearch);
	    req.setAttribute("top1pro", gettop1);
	    req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
