package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.ProductDao;
import vn.liquor.dao.impl.ProductDaoImpl;
import vn.liquor.model.CartItemModel;
import vn.liquor.model.ProductModel;
import vn.liquor.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public ProductModel getproduct(String pid) {
		// TODO Auto-generated method stub
		return productDao.getproduct(pid);
	}

	@Override
	public List<ProductModel> SearchByProductName(String txtSearch) {
		// TODO Auto-generated method stub
		return productDao.SearchByProductName(txtSearch);
	}

	@Override
	public int CountProduct() {
		// TODO Auto-generated method stub
		return productDao.CountProduct();
	}

	@Override
	public List<ProductModel> gettop1product() {
		// TODO Auto-generated method stub
		return productDao.gettop1product();
	}

	@Override
	public List<ProductModel> getnew8product() {
		// TODO Auto-generated method stub
		return productDao.getnew8product();
	}

	@Override
	public List<ProductModel> getallproduct() {
		// TODO Auto-generated method stub
		return productDao.getallproduct();
	}

	@Override
	public List<ProductModel> getallproductbycID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getallproductbycID(cid);
	}

	@Override
	public void insertProduct(ProductModel productModel) {
		productDao.insertProduct(productModel);

	}

	@Override
	public void updateProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		productDao.updateProduct(productModel);
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
	}

	@Override
	public ProductModel getproductbypid(int pid) {
		// TODO Auto-generated method stub
		return productDao.getproductbypid(pid);
	}

	@Override
	public List<ProductModel> getallproductbySid(int sid) {
		// TODO Auto-generated method stub
		return productDao.getallproductbySid(sid);
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}

	@Override
	public List<ProductModel> pagingProductByCID(int index, String cid) {
		// TODO Auto-generated method stub
		return productDao.pagingProductByCID(index, cid);
	}

	@Override
	public int countProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.countProductByCID(cid);
	}

	@Override
	public List<ProductModel> getProductByUseridSeller(String sellerid) {
		// TODO Auto-generated method stub
		return productDao.getProductByUseridSeller(sellerid);
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBan(String id) {
		// TODO Auto-generated method stub
		return productDao.ThongkeSLSanDaBan(id);
	}

	@Override
	public List<CartItemModel> ThongkeSLSanDaBanTheoNgay(String id, String date) {
		// TODO Auto-generated method stub
		return productDao.ThongkeSLSanDaBanTheoNgay(id, date);
	}

	@Override
	public void insertamount(int pid, String caid) {
		productDao.insertamount(pid, caid);

	}

	@Override
	public void insertsellamount(int pid, String caid) {
		productDao.insertsellamount(pid, caid);

	}

	@Override
	public void updateamount(int pid, String caid) {
		productDao.updateamount(pid, caid);

	}

}