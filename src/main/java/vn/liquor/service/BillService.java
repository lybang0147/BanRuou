package vn.liquor.service;

import vn.liquor.model.BillModel;

public interface BillService {
	public void insert(BillModel bill);

	public BillModel getbillbycaid(String caid);

}
