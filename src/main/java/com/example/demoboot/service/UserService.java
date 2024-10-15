package com.example.demoboot.service;

import com.example.demoboot.dto.UserDto;
import com.example.demoboot.entity.AppUser;

public interface UserService {
    AppUser findByUsername(String username);

    AppUser save(UserDto userDto);

}
