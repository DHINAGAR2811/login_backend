package com.example.demo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	@Override
    public List<LoginBean> findByUsernameOrEmail(String usernameOrEmail) {
        String sql;
        if(usernameOrEmail.contains("@")) {
        	sql = LoginQueryUtil.Query3;
        }
        else {
        	sql = LoginQueryUtil.Query2;
        }
        return jdbcTemplate.query(sql, new Object[]{usernameOrEmail}, this::mapRowToLoginBean);
    }

    @SuppressWarnings("deprecation")
	@Override
    public List<LoginBean> findByUsername(String username) {
        String sql = LoginQueryUtil.Query2;
        return jdbcTemplate.query(sql, new Object[]{username}, this::mapRowToLoginBean);
    }

    @SuppressWarnings("deprecation")
	@Override
    public List<LoginBean> findByEmail(String email) {
        String sql = LoginQueryUtil.Query3;
        return jdbcTemplate.query(sql, new Object[]{email}, this::mapRowToLoginBean);
    }

    private LoginBean mapRowToLoginBean(ResultSet rs, int rowNum) throws SQLException {
        return new LoginBean(
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email")
        );
    }
    public LoginBean registerUser(LoginBean bean) {
        jdbcTemplate.update(LoginQueryUtil.INSERT_USER, bean.getUsername(), bean.getPassword(), bean.getEmail());
        return bean;
    }
	@Override
	public void saveLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub
		
	}
}
