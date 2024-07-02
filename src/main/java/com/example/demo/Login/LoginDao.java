package com.example.demo.Login;

import java.util.List;

public interface LoginDao {
    List<LoginBean> findByUsernameOrEmail(String usernameOrEmail);
    List<LoginBean> findByUsername(String username);
    List<LoginBean> findByEmail(String email);
	void saveLogin(LoginBean loginBean);
	LoginBean registerUser(LoginBean bean);
}
