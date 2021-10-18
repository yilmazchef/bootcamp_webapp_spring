package com.stem.controllers;

import com.stem.mappers.RoleMapper;
import com.stem.models.RoleEntity;
import com.stem.models.RoleRequest;
import com.stem.models.RoleResponse;
import com.stem.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleCtrl {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public RoleResponse postRole(@RequestBody @Valid RoleRequest request,
                                 @RequestParam(required = false) @Positive Integer roleId) {

        if (request == null || request.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing information to create a role.");
        }

        return roleMapper.toResponse(
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
                        ));

    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    @Transactional
    public List<RoleResponse> getRoleList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") @Positive Integer pageNo,
            @RequestParam(required = false, defaultValue = "50") @Positive Integer pageSize) {

        return name.isEmpty() ? // IF NAME IS EMPTY
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
                        .toList();
    }


    @GetMapping("one")
    @ResponseStatus(HttpStatus.FOUND)
    @Transactional
    public RoleResponse getRole(@RequestParam @Positive Integer roleId) {

        if (roleId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "role id is required.");
        }

        return roleRepository
                .findById(roleId)
                .map(roleMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "role NOT found!"));

    }


}
