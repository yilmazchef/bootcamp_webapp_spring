package com.stem.controllers;

import com.stem.mappers.RoleMapper;
import com.stem.models.RoleEntity;
import com.stem.models.RoleRequest;
import com.stem.models.RoleResponse;
import com.stem.repositories.RoleRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public record RoleCtrl(RoleRepository roleRepository, RoleMapper roleMapper) {

    @PostMapping
    public ResponseEntity<RoleResponse> postRole(@RequestBody RoleRequest request,
                                                 @RequestParam(required = false) Integer roleId) {

        if (request == null || request.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing information to create a role.");
        }

        return ResponseEntity.ok(
                roleMapper.toResponse(
                        roleRepository.findOne(Example.of(
                                        roleMapper.toEntity(request)
                                ))
                                .map(entity ->
                                        roleRepository.save(
                                                roleMapper.toEntity(request, entity).withRoleId(roleId)
                                        )
                                ).orElse(
                                        roleRepository.save(
                                                roleMapper.toEntity(request)
                                        )
                                ))
        );

    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getRoleList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "50") Integer pageSize) {

        return ResponseEntity.ok(name.isEmpty() ? // IF NAME IS EMPTY
                roleRepository
                        .findAll(PageRequest.of(pageNo, pageSize))
                        .stream()
                        .map(roleMapper::toResponse)
                        .toList()
                : // IF NAME IS NOT EMPTY
                roleRepository
                        .findAll(Example.of(new RoleEntity().withRoleName(name)), PageRequest.of(pageNo, pageSize))
                        .stream()
                        .map(roleMapper::toResponse)
                        .toList()
        );
    }


    @GetMapping("{roleId}")
    public ResponseEntity<RoleResponse> getRole(@PathVariable("roleId") Integer roleId) {

        if (roleId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "role id is required.");
        }

        return roleRepository
                .findById(roleId)
                .map(roleMapper::toResponse)
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "role NOT found!"));

    }


}
