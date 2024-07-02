package com.example.demo.Register;

import java.util.List;

public interface RegisterDao {

	    List<RegisterBean> findByUsername( String username);

	    List<RegisterBean> findByEmail( String email);

		RegisterBean registerUser(RegisterBean bean);

		RegisterBean save(RegisterBean bean);

		List<RegisterBean> findByUsernameOrEmail(RegisterBean bean);

		List<RegisterBean> findByUsernameOrEmail(String username, String email);

		boolean existsByUsernameOrEmail(String username, String email);

		void saveUser(RegisterBean registerBean);
		
}
