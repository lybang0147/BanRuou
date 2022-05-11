package vn.liquor.service;

import java.util.List;

import vn.liquor.model.SellerInfoModel;
import vn.liquor.model.SellerModel;

public interface SellerService {
	void registerseller(SellerModel seller);
	void registerinfo(SellerInfoModel sellerinfo);
	SellerModel checkshopname(String shopname);
	SellerModel getsellerbyuid(int uid);
	void updateisseller(int uid);
	int daban(int sid);
	int tongdoanhthu(int sid);
	int tongsanpham(int sid);
	SellerModel getsellerbysid(int sid);
	List<SellerModel> getallseller();
}
