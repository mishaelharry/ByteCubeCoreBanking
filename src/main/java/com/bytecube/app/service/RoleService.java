/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.service;

import com.bytecube.app.dto.request.RoleRequest;
import com.bytecube.app.dto.response.RoleResponse;
import com.bytecube.app.model.Role;
import com.bytecube.app.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public boolean existsByName(String name) {
        return roleRepository.existsByRoleName(name).orElse(false);
    }

    public RoleResponse addRole(RoleRequest roleRequest) {
        RoleResponse roleResponse = null;
        Role role = new Role();
        role.setRoleName(roleRequest.getRoleName());
        if (!existsByName(roleRequest.getRoleName())) {
            Role result = roleRepository.save(role);
            if (result != null) {
                roleResponse = new RoleResponse();
                BeanUtils.copyProperties(role, roleResponse);
            }
        }
        return roleResponse;
    }

    public List<RoleResponse> getRoles() {
        List<RoleResponse> roleResponses = new ArrayList<>();
        List<Role> roleList = roleRepository.findAll();

        roleList.stream().forEach((role) -> {
            RoleResponse roleResponse = new RoleResponse();
            BeanUtils.copyProperties(role, roleResponse);
            roleResponses.add(roleResponse);
        });
        return roleResponses;
    }

    public Role getRole(String name) {
        return roleRepository.findByRoleName(name).orElse(null);
    }

    public RoleResponse getRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        RoleResponse roleResponse = null;
        if (role != null) {
            roleResponse =  new RoleResponse();
            BeanUtils.copyProperties(role, roleResponse);
        }
        return roleResponse;
    }

    public RoleResponse updateRole(Long roleId, RoleRequest roleRequest) {
        RoleResponse roleResponse = null;
        Role role = new Role();
        role.setId(roleId);
        role.setRoleName(roleRequest.getRoleName());
        Role result = roleRepository.save(role);
        if (result != null) {
            roleResponse = new RoleResponse();
            BeanUtils.copyProperties(result, roleResponse);
        }
        return roleResponse;
    }

    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }
    
}
