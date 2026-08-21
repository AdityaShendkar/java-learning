package com.springsecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class Home {

    @GetMapping
    public ResponseEntity<String> getHome(){
        return ResponseEntity.ok("Home Page Retrived Successfully");
    }

    @PostMapping
    public ResponseEntity<String> createHome(){
        return ResponseEntity.ok("Home Page Created Successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateHome(){
        return ResponseEntity.ok("Home Page Updated successfully") ;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteHome(){
        return ResponseEntity.ok("Home Page deleted successfully") ;
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
