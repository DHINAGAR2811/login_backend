package com.example.demo.Register;

public class RegisterBean {
	  private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private String usernameOrEmail;
	    public RegisterBean() {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.email = email;
	    }
		
		public RegisterBean(String username, String password, String email) {
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsernameOrEmail() {
			return usernameOrEmail;
		}

		public void setUsernameOrEmail(String username, String email) {
			this.username = username;
			this.email =email;
		}
	    
	    
}
