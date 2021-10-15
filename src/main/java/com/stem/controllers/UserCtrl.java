package com.stem.controllers;

import com.stem.mappers.UserMapper;
import com.stem.models.UserEntity;
import com.stem.models.UserRequest;
import com.stem.models.UserResponse;
import com.stem.repositories.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public record UserCtrl(UserRepository userRepository, UserMapper userMapper) {

    @PostMapping
    public ResponseEntity<UserResponse> postUser(@RequestBody UserRequest request,
                                                 @RequestParam(required = false) Integer userId) {

        if (request == null || request.email().isEmpty() || request.passCode().isEmpty() || request.roleId() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing information to create a user.");
        }

        return ResponseEntity.ok(
                userMapper.toResponse(
                        userRepository.findOne(Example.of(
                                        userMapper.toEntity(request)
                                ))
                                .map(entity ->
                                        userRepository.save(
                                                userMapper.toEntity(request, entity).withId(userId)
                                        )
                                ).orElse(
                                        userRepository.save(
                                                userMapper.toEntity(request)
                                        )
                                ))
        );

    }

    @GetMapping("many")
    public ResponseEntity<List<UserResponse>> getUserList(
            @RequestParam(required = false) String phone,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "50") Integer pageSize) {

        return ResponseEntity.ok(email.isEmpty() ? // IF NAME IS EMPTY
                userRepository
                        .findAll(PageRequest.of(pageNo, pageSize))
                        .stream()
                        .map(userMapper::toResponse)
                        .toList()
                : // IF NAME IS NOT EMPTY
                userRepository
                        .findAll(Example.of(new UserEntity().withEmail(email)), PageRequest.of(pageNo, pageSize))
                        .stream()
                        .map(userMapper::toResponse)
                        .toList()
        );
    }


    @GetMapping("one")
    public ResponseEntity<UserResponse> getUser(@RequestParam(required = false) Integer userId,
                                                @RequestParam(required = false) String email) {

        if (userId == null && email.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user id is required.");
        }

        return userId != null ?
                userRepository
                        .findById(userId)
                        .map(userMapper::toResponse)
                        .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user NOT found!"))
                :
                userRepository
                        .findByEmailContainingIgnoreCase(email)
                        .map(userMapper::toResponse)
                        .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user NOT found!"))
    }


}
