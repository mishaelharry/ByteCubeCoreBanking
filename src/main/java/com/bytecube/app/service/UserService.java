/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecube.app.service;

import com.bytecube.app.dto.request.LoginRequest;
import com.bytecube.app.dto.request.UserRequest;
import com.bytecube.app.dto.response.LoginResponse;
import com.bytecube.app.dto.response.UserResponse;
import com.bytecube.app.model.Role;
import com.bytecube.app.model.User;
import com.bytecube.app.repository.RoleRepository;
import com.bytecube.app.repository.UserRepository;
import com.bytecube.app.security.JwtTokenProvider;
import com.bytecube.app.security.UserPrincipal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User not found with email : " + username)
                );
        return UserPrincipal.create(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UserDetails loadUserById(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public LoginResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        LoginResponse loginResponse = null;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        if (principal != null) {
            loginResponse = new LoginResponse();
            String jwt = jwtTokenProvider.generateAccessToken(authentication);
            UserResponse userResponse = getUserById(principal.getId());
            loginResponse.setAccessToken(jwt);
            loginResponse.setUser(userResponse);
        }
        return loginResponse;
    }
    
    public UserResponse getUserById(Long userId){
        UserResponse userResponse = null;
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            userResponse.setRoles(getRole(user.getRoles()));
        }
        return userResponse;
    }
    
    private String[] getRole(Collection<Role> role){
        String[] roleName = new String[role.size()];
        List<Role> roleList = new ArrayList<>(role);
        for(int i = 0; i < role.size(); i++){
            roleName[i] = roleList.get(i).getRoleName();
        }
        return roleName;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User addUser(UserRequest userRequest) {
        Role role = roleRepository.findByRoleName(userRequest.getRoleName()).orElse(null);        
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setStatus(0);
        user.setRoles(Collections.singleton(role));
        return userRepository.save(user);
    }

    public List<UserResponse> getUserByRole(String role) {
        List<UserResponse> userResponses = new ArrayList<>();
        List<User> users = userRepository.findUserByRole(role);
        
        users.forEach((user) -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            userResponses.add(userResponse);
        });
        return userResponses;
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void updateUserStatus(User user, int status) {
        user.setStatus(status);
        userRepository.save(user);
    }
    
}
