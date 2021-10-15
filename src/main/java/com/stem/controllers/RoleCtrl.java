package com.stem.controllers;

import com.stem.models.RoleRequest;
import com.stem.models.RoleResponse;
import com.stem.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleCtrl {

    private final RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<RoleResponse> createSingle(@RequestBody RoleRequest request) {


    }


}
