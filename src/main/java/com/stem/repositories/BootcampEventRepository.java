package com.stem.repositories;

import com.stem.models.BootcampEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampEventRepository extends JpaRepository<BootcampEvent, Integer> {
}