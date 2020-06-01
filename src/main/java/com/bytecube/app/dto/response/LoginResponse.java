/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.dto.response;

import lombok.Data;

/**
 *
 * @author hp
 */
@Data
public class LoginResponse {
    
    private String accessToken;
    private String tokenType = "Bearer";
    private UserResponse user;
    
}
