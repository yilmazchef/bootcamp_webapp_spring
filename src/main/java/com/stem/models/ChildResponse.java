package com.stem.models;

import java.time.LocalDate;

public record ChildResponse(Integer id,
                            AdultEntity adult,
                            String firstName,
                            String lastName, LocalDate dateOfBirth,
                            UserResponse user) {
}
