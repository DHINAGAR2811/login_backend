package com.example.demo.Register;

import java.util.List;

public interface RegisterService {

  
    List<RegisterBean> findByUsername( String username);

    List<RegisterBean> findByEmail( String email);

	 RegisterBean register(RegisterBean bean) ;

	List<RegisterBean> findByUsernameOrEmail(String username, String email);

	boolean existsByUsernameOrEmail(String username, String email);

}