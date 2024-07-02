package com.example.demo.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public LoginBean loginUser(String usernameOrEmail, String password) {
        List<LoginBean> users = loginDao.findByUsernameOrEmail(usernameOrEmail);
        if (!users.isEmpty()) {
            LoginBean user = users.get(0); // Assuming username or email is unique, so we take the first result
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Invalid username/email or password");
    }

	@Override
	public List<LoginBean> findByUsernameOrEmail(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginBean> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginBean> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
