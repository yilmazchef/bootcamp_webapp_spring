package com.stem.repositories;

import com.stem.models.BootcampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampEventRepository extends JpaRepository<BootcampEntity, Integer> {
}