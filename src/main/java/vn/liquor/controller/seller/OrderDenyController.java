package vn.liquor.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.liquor.model.CartItemModel;
import vn.liquor.service.CartItemService;
import vn.liquor.service.ProductService;
import vn.liquor.service.impl.CartItemServiceImpl;
import vn.liquor.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns = { "/seller/order/deny" })
public class OrderDenyController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6574130615613495360L;
	CartItemService cartitemservice = new CartItemServiceImpl();
	ProductService productservice = new ProductServiceImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	String ciid=req.getParameter("ciid");
	String caid=req.getParameter("caid");
	CartItemModel cartitem = cartitemservice.getbycitemid(Integer.parseInt(ciid));
	cartitemservice.deny(Integer.parseInt(ciid));
	productservice.insertamount(cartitem.getProduct().getProductId(), caid);
	resp.sendRedirect(req.getContextPath() +"/seller/order");
}
}