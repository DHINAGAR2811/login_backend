package com.example.demo.Register;

public class RegisterQueryUtil {
	
	public static final String INSERT_USER = "INSERT INTO user_details (username, password, email) VALUES (?, ?, ? )";

	public static final String Query1 = "SELECT * FROM user_details WHERE usernameOrEmail = ?";
	
	public static final String Query2 = "SELECT * FROM user_details WHERE username = ?";
	
	public static final String Query3 =  "SELECT * FROM user_details WHERE email = ?";

}
