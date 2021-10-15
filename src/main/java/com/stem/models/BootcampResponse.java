package com.stem.models;

import java.time.LocalDate;
import java.time.LocalTime;

public record BootcampResponse(Integer id,
                               String title, String description,
                               LocalDate eventDate, LocalTime eventTime,
                               byte[] imageUrl) {
}
