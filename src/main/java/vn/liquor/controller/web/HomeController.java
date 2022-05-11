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

@WebServlet(urlPatterns = { "/home", "/trang-chu" })
public class HomeController extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 203632274729586389L;
	ProductService productservice = new ProductServiceImpl();
	CategoryService categoryservice = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Khởi tạo các biến
		List<ProductModel> listtop1 = productservice.gettop1product();
		List<ProductModel> listnew8 = productservice.getnew8product();
		List<CategoryModel> listtop6cate = categoryservice.get6cate();
		List<CategoryModel> listallcate = categoryservice.getallCate();
		// Gán các list
		req.setAttribute("listtop1", listtop1);
		req.setAttribute("list8", listnew8);
		req.setAttribute("list6cate", listtop6cate);
		req.setAttribute("listallcate", listallcate);
		// req.setAttribute("lostnew8", listnew8);
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}
}
