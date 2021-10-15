package com.stem.models;

import java.time.LocalDate;

public record ChildRequest(Integer adultId,
                           String firstName,
                           String lastName, LocalDate dateOfBirth,
                           Integer userId) {
}
