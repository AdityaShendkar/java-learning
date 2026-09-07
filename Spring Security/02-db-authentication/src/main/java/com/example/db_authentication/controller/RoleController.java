package com.example.db_authentication.controller;

import com.example.db_authentication.entity.Role;
import com.example.db_authentication.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> addRoles(@RequestBody Role role){
        roleService.addRole(role);
        return ResponseEntity.ok("DONE");
    }
}
