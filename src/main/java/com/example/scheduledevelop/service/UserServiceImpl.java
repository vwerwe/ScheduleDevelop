package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.responseDto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.exception.DuplicateSignUpException;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto save(String username, String password, String email) {

        userRepository.findUserByUsername(username);

        Optional<User> checkUser = userRepository.findUserByUsernameOrEmail(username, email);

        if (checkUser.isPresent()) {
            throw new DuplicateSignUpException("이미 사용중인 이메일 또는 이름 입니다");
        }


        User user = new User(username, password, email);

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

    @Transactional
    @Override
    public UserResponseDto updateUsername(Long id, String username, String password) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findUser.setUsername(username);

        return new UserResponseDto(findUser);
    }

    @Override
    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }

    @Override
    public UserResponseDto login(String email, String password) {

        User findUser = userRepository.findUserByEmailAndPasswordOrElseThrow(email);

        if (!password.equals(findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "잘못된 인력값입니다");
        }

        return new UserResponseDto(findUser);

    }
}
