package com.example.demo.Login;

import java.util.List;

public interface LoginService {

    List<LoginBean> findByUsernameOrEmail(String usernameOrEmail);

    List<LoginBean> findByUsername(String username);

    List<LoginBean> findByEmail(String email);

    LoginBean loginUser(String usernameOrEmail, String password);
}
