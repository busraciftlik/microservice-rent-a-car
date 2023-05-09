package com.busraciftlik.inventoryservice.repository;

import com.busraciftlik.inventoryservice.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
