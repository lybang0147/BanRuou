package vn.liquor.controller.admin;

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

@WebServlet(urlPatterns = { "/admin/deleteproduct" })
public class ProductDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3169542456098085103L;
	ProductService productservice = new ProductServiceImpl();
	CategoryService cateservice = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String proid = req.getParameter("pid");
		productservice.deleteProduct(Integer.parseInt(proid));
		List<ProductModel> listproduct = productservice.getallproduct();
		List<CategoryModel> listcate = cateservice.getallCate();
		req.setAttribute("listcate", listcate);
		req.setAttribute("listproduct", listproduct);
		resp.sendRedirect(req.getContextPath() + "/admin/product");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
