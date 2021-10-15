package com.stem.models;

import java.time.LocalDate;

public record AdultResponse(Integer id, String firstName, String lastName, LocalDate dateOfBirth, UserResponse user) {
}
