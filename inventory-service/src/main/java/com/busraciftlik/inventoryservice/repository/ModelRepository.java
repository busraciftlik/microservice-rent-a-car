package com.busraciftlik.inventoryservice.repository;

import com.busraciftlik.inventoryservice.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
}
