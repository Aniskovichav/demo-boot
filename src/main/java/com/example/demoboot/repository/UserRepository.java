package com.example.demoboot.repository;

import com.example.demoboot.dto.UserDto;
import com.example.demoboot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

    AppUser save(UserDto userDto);
}
