package com.example.controller;

import com.example.model.Loginrequest;
import com.example.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins ="*")
public class loginController {

    private static final Logger logger = LogManager.getLogger(loginController.class);
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Loginrequest loginrequest) throws Exception{
        System.out.println(loginrequest);
        logger.info("[" + HttpStatus.OK + "]");
        return ResponseEntity.ok(loginService.SignIn_Service(loginrequest));
    }

}
