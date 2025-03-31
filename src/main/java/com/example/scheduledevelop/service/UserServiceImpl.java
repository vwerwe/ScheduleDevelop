package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(String username, String email) {

        User user = new User(username, email);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> findAll() {

        List<User> findAllUser = userRepository.findAll();


        return findAllUser.stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findById(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(findUser);

    }
}
