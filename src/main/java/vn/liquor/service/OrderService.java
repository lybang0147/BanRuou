package vn.liquor.service;

import java.util.List;

import vn.liquor.model.OrderModel;

public interface OrderService {
	public List<OrderModel> getorderbysid(int sid); 
	public List<OrderModel> getorderbyuid(int uid);
}
