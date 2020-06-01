package com.bytecube.app;

import com.bytecube.app.dto.request.RoleRequest;
import com.bytecube.app.dto.request.UserRequest;
import com.bytecube.app.service.RoleService;
import com.bytecube.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BytecubeCorebankingApplication {
    
    @Value("${app.admin.username}")
    private String username;
    
    @Value("${app.admin.password}")
    private String password;
    
    @Value("${app.admin.rolename}")
    private String roleName;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BytecubeCorebankingApplication.class, args);
    }
    
    @EventListener
    public void seed(ContextRefreshedEvent event){
        System.out.println("Seeding Database...");
        
        RoleRequest superAdminRole = new RoleRequest();
        superAdminRole.setRoleName("SUPER_ADMIN");
        roleService.addRole(superAdminRole);
        
        RoleRequest adminRole = new RoleRequest();
        adminRole.setRoleName("ADMIN");
        roleService.addRole(adminRole);
        
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(username);
        userRequest.setPassword(password);
        userRequest.setRoleName(roleName);
        
        if(!userService.existsByUsername(userRequest.getUsername())){
            userService.addUser(userRequest);
        }
    }

}
