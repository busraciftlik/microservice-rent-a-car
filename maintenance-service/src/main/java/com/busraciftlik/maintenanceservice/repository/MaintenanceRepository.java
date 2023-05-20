package com.busraciftlik.maintenanceservice.repository;

import com.busraciftlik.maintenanceservice.entities.Maintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MaintenanceRepository extends MongoRepository<Maintenance, UUID> {
}
