package com.busraciftlik.common.events.inventory;

import com.busraciftlik.common.events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDeletedEvent implements Event {
    private UUID carId;
}