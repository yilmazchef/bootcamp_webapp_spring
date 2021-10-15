package com.stem.repositories;

import com.stem.models.AdultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdultRepository extends JpaRepository<AdultEntity, Integer> {
}