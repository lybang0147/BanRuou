package vn.liquor.service;

import java.util.List;

import vn.liquor.model.CategoryModel;

public interface CategoryService {
	List<CategoryModel> get6cate();
	List<CategoryModel> getallCate();
	int CountAllCate();
	void insert(CategoryModel cate);
	CategoryModel getCate(int cid);
	void edit(CategoryModel cate);
	void delete(int cid);
}
