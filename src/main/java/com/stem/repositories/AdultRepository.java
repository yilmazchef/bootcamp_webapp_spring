package com.stem.repositories;

import com.stem.models.Adult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdultRepository extends JpaRepository<Adult, Integer> {
}