package com.busraciftlik.inventoryservice.repository;

import com.busraciftlik.inventoryservice.entities.Car;
import com.busraciftlik.inventoryservice.entities.enums.State;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Modifying
    @Transactional
    @Query(value = "update Car set state =:state where id =:id")
    void changeStateByCarId(State state, UUID id);
}
