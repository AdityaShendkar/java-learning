package com.springsecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public ResponseEntity<String> getHome(){
        return ResponseEntity.ok("Welcome To Home Page....");
    }

}
