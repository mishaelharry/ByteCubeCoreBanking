/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.controller;

import com.bytecube.app.dto.request.LoginRequest;
import com.bytecube.app.dto.response.BaseResponse;
import com.bytecube.app.dto.response.LoginResponse;
import com.bytecube.app.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        if (loginResponse != null) {
            return new ResponseEntity(new BaseResponse(true, "Login successful", loginResponse),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity(new BaseResponse<>(false, "Login failed", loginResponse),
                    HttpStatus.UNAUTHORIZED);
        }
    }
    
}
