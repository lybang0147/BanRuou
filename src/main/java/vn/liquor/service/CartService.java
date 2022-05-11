package vn.liquor.service;

import java.util.List;

import vn.liquor.model.CartModel;

public interface CartService {

	void insert(CartModel cart);

	void edit(CartModel cart);

	void delete(int id);

	CartModel get(String id);

	List<CartModel> getAll();

	List<CartModel> search(String name);

	public CartModel getCart();

	List<CartModel> getAllCart();
	CartModel getCart(String id);
	List<CartModel> getcartbyuid(int uid) ;
}
