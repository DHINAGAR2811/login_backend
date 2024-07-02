package com.example.demo.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RegisterControllor {

    @Autowired
    private RegisterService registerService;
    
    @RequestMapping("/register")
    public ResponseEntity<ResultBean> registerUser(@RequestBody RegisterBean registerBean) {
        ResultBean result = new ResultBean();
        try {
            if (registerService.existsByUsernameOrEmail(registerBean.getUsername(), registerBean.getEmail())) {
                result.setSuccess(false);
                result.setError("Username or email already exists");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
            }
            registerService.register(registerBean);
            result.setSuccess(true);
            result.setMessage("User registered successfully");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setError("An error occurred during registration");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @RequestMapping("/checkUsernameOrEmail")
    public ResponseEntity<ResultBean> checkUsernameOrEmail(@RequestParam String username, @RequestParam String email) {
        ResultBean result = new ResultBean();
        boolean exists = registerService.existsByUsernameOrEmail(username, email);
        result.setSuccess(!exists);
        result.setMessage(exists ? "Username or email already exists" : "Username or email available");
        return ResponseEntity.ok(result);
    }
    
}
