package com.stem.repositories;

import com.stem.models.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<ChildEntity, Integer> {
}