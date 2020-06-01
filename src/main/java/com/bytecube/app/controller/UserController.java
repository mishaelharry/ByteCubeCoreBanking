/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.controller;

import com.bytecube.app.dto.request.UserRequest;
import com.bytecube.app.dto.response.BaseResponse;
import com.bytecube.app.dto.response.UserResponse;
import com.bytecube.app.model.User;
import com.bytecube.app.service.UserService;
import com.bytecube.app.util.Constant;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @GetMapping("admins")
    public ResponseEntity<BaseResponse<List<UserResponse>>> getAdmins() {
        List<UserResponse> userResponses = userService.getUserByRole(Constant.ADMIN_ROLE);
        if(userResponses != null){
            return ResponseEntity.ok(new BaseResponse(true, "Admin retrieved successfully", userResponses));
        } else {
            return new ResponseEntity<>(new BaseResponse(false, "Admin not found.", null),
                    HttpStatus.OK);
        }        
    }
    
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @GetMapping("super-admins")
    public ResponseEntity<BaseResponse<List<UserResponse>>> getSuperAdmins() {
        List<UserResponse> userResponses = userService.getUserByRole(Constant.SUPER_ADMIN_ROLE);
        if(userResponses != null){
            return ResponseEntity.ok(new BaseResponse(true, "Super admin retrieved successfully", userResponses));
        } else {
            return new ResponseEntity<>(new BaseResponse(false, "Super admin not found.", null),
                    HttpStatus.OK);
        }        
    }
    
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    @PostMapping("admins")
    public ResponseEntity<?> createAdmin(@Valid @RequestBody UserRequest userRequest) {
        if (userService.existsByUsername(userRequest.getUsername())) {
            return ResponseEntity.ok(new BaseResponse(false, "Username already exist", null));
        }

        userRequest.setRoleName("ADMIN");
        User user = userService.addUser(userRequest);
        if (user != null) {
            return ResponseEntity.ok(new BaseResponse<>(true, "Admin created successfully", user));
        } else {
            return ResponseEntity.ok(new BaseResponse<>(false, "Failed to create admin", null));
        }
    }
    
    @GetMapping("/block/{userId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public ResponseEntity<BaseResponse> blockUser(@PathVariable("userId") Long userId){        
        User user = userService.getOneUserById(userId);
        
        if(user != null){
            userService.updateUserStatus(user, 0);
            return ResponseEntity.ok(new BaseResponse(true, "User blocked.",
                null
            ));
        } else {
            return ResponseEntity.ok(new BaseResponse(false, "User not found.",
                null
            ));
        }          
    }
}
