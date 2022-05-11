package vn.liquor.service.impl;

import java.util.List;

import vn.liquor.dao.CategoryDao;
import vn.liquor.dao.impl.CategoryDaoImpl;
import vn.liquor.model.CategoryModel;
import vn.liquor.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> get6cate() {
		// TODO Auto-generated method stub
		return categoryDao.get6cate();
	}
	@Override
	public List<CategoryModel> getallCate() {
		// TODO Auto-generated method stub
		return categoryDao.getallCate();
	}
	@Override
	public int CountAllCate() {
		// TODO Auto-generated method stub
		return categoryDao.CountAllCate();
	}
	@Override
	public void insert(CategoryModel cate) {
		categoryDao.insert(cate);
		
	}
	@Override
	public CategoryModel getCate(int cid) {
		// TODO Auto-generated method stub
		return categoryDao.getCate(cid);
	}
	@Override
	public void edit(CategoryModel cate) {
		categoryDao.edit(cate);	
	}
	@Override
	public void delete(int cid) {
		categoryDao.delete(cid);	
		
	}

}
