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
public class UserResponse {
    
    private Long id;
    
    private String username;        
        
    private String[] roles;
    
}
