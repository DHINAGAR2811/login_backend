package com.example.demo.Register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterDao dao ;

	
	@Override
	public List<RegisterBean> findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public List<RegisterBean> findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public List<RegisterBean> findByUsernameOrEmail(String username,String email) {
		return dao.findByUsernameOrEmail(username, email);
	}

    public RegisterBean registerUser(RegisterBean bean) {
        if (bean.getUsernameOrEmail() ==  bean.getUsername()||bean.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        List<RegisterBean> existingUsers = dao.findByUsernameOrEmail(bean.getUsername(), bean.getEmail());
        if (!existingUsers.isEmpty()) {
            String existing = existingUsers.get(0).getUsername().equals(bean.getUsername()) ? "username" : "email";
            throw new IllegalArgumentException(existing + " user name or email already exists");
        }

        return dao.save(bean);

    }

	@Override
	public RegisterBean register(RegisterBean bean) {
		// TODO Auto-generated method stub
		return dao.registerUser(bean);
	}

	@Override
	public boolean existsByUsernameOrEmail(String username, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
