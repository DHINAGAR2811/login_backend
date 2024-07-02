package com.example.demo.Register;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegisterDaoImpl implements RegisterDao {

    private final JdbcTemplate jdbcTemplate;

    public RegisterDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUser(RegisterBean registerBean) {
        jdbcTemplate.update(RegisterQueryUtil.INSERT_USER, 
            registerBean.getUsername(), 
            registerBean.getEmail(), 
            registerBean.getPassword()
        );
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public boolean existsByUsernameOrEmail(String username, String email) {
        List<RegisterBean> users = jdbcTemplate.query(
            RegisterQueryUtil.Query1,
            new Object[]{username, email},
            (rs, rowNum) -> new RegisterBean(
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
            )
        );
        return !users.isEmpty();
    }
	 @Override
	    public RegisterBean registerUser(RegisterBean bean) {
	        jdbcTemplate.update(RegisterQueryUtil.INSERT_USER, bean.getUsername(), bean.getPassword(), bean.getEmail());
	        return bean;
	    }

	@Override
	public RegisterBean save(RegisterBean bean) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegisterBean> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegisterBean> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegisterBean> findByUsernameOrEmail(RegisterBean bean) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RegisterBean> findByUsernameOrEmail(String username, String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
