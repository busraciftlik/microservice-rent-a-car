package com.busraciftlik.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;
    private String name;

   @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
