/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.repository;

import com.bytecube.app.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Optional<Boolean> existsByRoleName(String roleName);
        
    Optional<Role> findByRoleName(String roleName);
}
