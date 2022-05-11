package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.CartItemDao;
import vn.liquor.dao.impl.CartItemDaoImpl;
import vn.liquor.model.CartItemModel;
import vn.liquor.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	CartItemDao cartitemdao = new CartItemDaoImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		// TODO Auto-generated method stub
		cartitemdao.insert(cartItem);
	}

	@Override
	public void edit(CartItemModel cartItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartItemModel get(int id) {
		// TODO Auto-generated method stub
		return cartitemdao.get(id);
	}

	@Override
	public List<CartItemModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel getbycitemid(int id) {
		// TODO Auto-generated method stub
		return cartitemdao.getbycitemid(id);
	}

	@Override
	public List<CartItemModel> getAllCartItem(String id) {
		// TODO Auto-generated method stub
		return cartitemdao.getAllCartItem(id);
	}

	@Override
	public void accept(int cid) {
		cartitemdao.accept(cid);

	}

	@Override
	public void deny(int cid) {
		cartitemdao.deny(cid);

	}

}
