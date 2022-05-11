package vn.liquor.service;

import java.util.List;

import vn.liquor.model.AccountDetailModel;
import vn.liquor.model.AccountModel;

public interface UserService {
	void insert(AccountModel user);

	AccountModel get(int id);

	int countAllAccount();

	AccountDetailModel layaccountdetail(int id);

	void editdetail(AccountDetailModel user);

	void editdetailimage(AccountDetailModel user);

	List<AccountModel> getalluser();

	void ban(int id);

	void unban(int id);

	void delete(int id);

	void deletedetail(int id);

	void register(AccountModel acc);

	AccountModel checkuser(String username);

	void adddetail(AccountDetailModel user);
	List<AccountDetailModel> getalluserdetail();
}
