/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.repository;

import com.bytecube.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT users.id, users.username, users.status, roles.name FROM users INNER JOIN user_roles ON users.id = user_roles.user_id INNER JOIN roles ON roles.id = user_roles.role_id WHERE roles.role_name = :roleName", nativeQuery = true)
    List<User> findUserByRole(String roleName);
    
}
