/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author hp
 */
@Data
public class UserRequest {
    
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    private String roleName;
    
}
