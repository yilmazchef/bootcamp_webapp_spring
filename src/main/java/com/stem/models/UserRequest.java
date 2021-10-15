package com.stem.models;

public record UserRequest(String email, String phone, String passCode, Integer roleId) {
}
