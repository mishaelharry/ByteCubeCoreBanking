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
public class RoleRequest {
    
    @NotBlank(message = "Role name is required")
    private String roleName;
    
}
