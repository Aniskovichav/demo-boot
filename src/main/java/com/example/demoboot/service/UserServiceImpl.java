package com.example.demoboot.service;

import com.example.demoboot.dto.UserDto;
import com.example.demoboot.entity.AppUser;
import com.example.demoboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser save(UserDto userDto) {
        AppUser user = new AppUser(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getFullname());
        return userRepository.save(user);
    }

}
