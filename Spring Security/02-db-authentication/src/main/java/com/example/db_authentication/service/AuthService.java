package com.example.db_authentication.service;

import com.example.db_authentication.dto.UserRegisterRequestDto;
import com.example.db_authentication.dto.UserRegisterResponseDto;
import com.example.db_authentication.entity.Role;
import com.example.db_authentication.entity.User;
import com.example.db_authentication.repository.RoleRepository;
import com.example.db_authentication.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    public AuthService(UserRepository userRepository) {
//        this.userRepository = userRepository;
////        this.passwordEncoder = passwordEncoder;
//    }

    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {
        User user = new User();
        user.setUsername(userRegisterRequestDto.getUsername());
//        user.setPassword(userRegisterRequestDto.getPassword());
        String encodedPassword = passwordEncoder.encode(userRegisterRequestDto.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();
        userRegisterResponseDto.setUsername(user.getUsername());
        userRegisterResponseDto.setMessage("User saved successfully");
        return userRegisterResponseDto;
    }
}
