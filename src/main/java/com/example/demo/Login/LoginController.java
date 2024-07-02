package com.example.demo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/authenticate")
    public ResponseEntity<?> loginUser(@RequestBody LoginBean loginBean) {
        try {
            LoginBean authenticatedUser = loginService.loginUser(loginBean.getUsernameormail(), loginBean.getPassword());
            return ResponseEntity.ok(authenticatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @RequestMapping("/findByUsernameOrEmail")
    public ResponseEntity<List<LoginBean>> findByUsernameOrEmail(@RequestParam String usernameOrEmail) {
        return ResponseEntity.ok(loginService.findByUsernameOrEmail(usernameOrEmail));
    }

    @RequestMapping("/findByUsername")
    public ResponseEntity<List<LoginBean>> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(loginService.findByUsername(username));
    }

    @RequestMapping("/findByEmail")
    public ResponseEntity<List<LoginBean>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(loginService.findByEmail(email));
    }
}
