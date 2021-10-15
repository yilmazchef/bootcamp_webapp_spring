package com.stem.models;

public record UserResponse(Integer id, String email, String phone, String passCode, RoleEntity role) {
}
