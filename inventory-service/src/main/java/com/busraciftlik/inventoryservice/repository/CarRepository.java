package com.busraciftlik.inventoryservice.repository;

import com.busraciftlik.inventoryservice.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
