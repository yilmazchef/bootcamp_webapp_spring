package com.stem.models;

import java.time.LocalDate;

public record AdultRequest(String firstName, String lastName, LocalDate dateOfBirth, Integer userId) {
}
