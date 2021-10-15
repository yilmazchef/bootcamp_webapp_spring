package com.stem.repositories;

import com.stem.models.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampEventRepository extends JpaRepository<Bootcamp, Integer> {
}