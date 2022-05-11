package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.CartDao;
import vn.liquor.dao.impl.CartDaoImpl;
import vn.liquor.model.CartModel;
import vn.liquor.service.CartService;

public class CartServiceImpl implements CartService {
	CartDao cartdao = new CartDaoImpl();

	@Override
	public void insert(CartModel cart) {
		// TODO Auto-generated method stub
		cartdao.insert(cart);
	}

	@Override
	public void edit(CartModel cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartModel get(String id) {
		// TODO Auto-generated method stub
		return cartdao.get(id);
	}

	@Override
	public List<CartModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartModel getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartModel> getAllCart() {
		// TODO Auto-generated method stub
		return cartdao.getAllCart();
	}

	@Override
	public CartModel getCart(String id) {
		// TODO Auto-generated method stub
		return cartdao.getCart(id);
	}

	@Override
	public List<CartModel> getcartbyuid(int uid) {
		// TODO Auto-generated method stub
		return cartdao.getcartbyuid(uid);
	}

}
