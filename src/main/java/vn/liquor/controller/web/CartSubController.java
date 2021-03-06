package vn.liquor.controller.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.liquor.model.CartItemModel;
import vn.liquor.model.ProductModel;
import vn.liquor.service.ProductService;
import vn.liquor.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/cart-sub" })
public class CartSubController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3432714552350217110L;
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String pId = req.getParameter("pId");
		String quantity = req.getParameter("quantity");

		ProductModel product = productService.getproduct(pId);

		CartItemModel cartItem = new CartItemModel();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice(product.getPrice());
		cartItem.setProduct(product);

		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");

		if (obj == null) {
			Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			map.put(cartItem.getProduct().getProductId(), cartItem);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, CartItemModel> map = extracted(obj);
			CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
			if (existedCartItem == null) {
				map.put(product.getProductId(), cartItem);
			} else {
				if(existedCartItem.getQuantity() > 1) {
					existedCartItem.setQuantity(existedCartItem.getQuantity() - Integer.parseInt(quantity));
					httpSession.setAttribute("cart", map);
				} else
				{
					 map = (Map<Integer, CartItemModel>) obj; // ep ve kieu cua no
	                 // Xoa san pham trong map
	                 map.remove(Integer.parseInt(pId));
					httpSession.setAttribute("cart", map);
				}
			}			
		}

		resp.sendRedirect(req.getContextPath() + "/member/cart");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}
