package com.example.scheduledevelop.dto.responseDto;

import com.example.scheduledevelop.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;

    private String username;

    private String email;

    public UserResponseDto (User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
