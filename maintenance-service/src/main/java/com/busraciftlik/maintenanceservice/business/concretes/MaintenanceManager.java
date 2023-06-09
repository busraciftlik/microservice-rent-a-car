package com.busraciftlik.maintenanceservice.business.concretes;

import com.busraciftlik.common.events.maintenance.MaintenanceCompletedEvent;
import com.busraciftlik.common.events.maintenance.MaintenanceCreatedEvent;
import com.busraciftlik.common.events.maintenance.MaintenanceDeletedEvent;
import com.busraciftlik.common.kafka.producer.KafkaProducer;
import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.maintenanceservice.business.abstracts.MaintenanceService;
import com.busraciftlik.maintenanceservice.business.dto.requests.create.CreateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.requests.update.UpdateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.responses.create.CreateMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetAllMaintenancesResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.update.UpdateMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.rules.MaintenanceBusinessRules;
import com.busraciftlik.maintenanceservice.entities.Maintenance;
import com.busraciftlik.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapperService mapper;
    private final KafkaProducer producer;
    private final MaintenanceBusinessRules rules;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        var maintenances = repository.findAll();
        var responses = maintenances
                .stream()
                .map(maintenance -> mapper.forResponse().map(maintenance, GetAllMaintenancesResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetMaintenanceResponse getById(UUID id) {
        var maintenance = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        rules.ensureCarIsAvailable(request.getCarId());
        var maintenance = mapper.forRequest().map(request, Maintenance.class);
        maintenance.setId(null);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        repository.save(maintenance);

        sendKafkaMaintenanceCreatedEvent(request.getCarId());
        var response = mapper.forResponse().map(maintenance, CreateMaintenanceResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request) {
        rules.checkIfMaintenanceExists(id);
        var maintenance = mapper.forRequest().map(request, Maintenance.class);
        maintenance.setId(id);

        if (maintenance.isCompleted()) {
            maintenance.setEndDate(LocalDateTime.now());
            sendKafkaMaintenanceCompletedEvent(maintenance.getCarId());
        }

        repository.save(maintenance);

        var response = mapper.forResponse().map(maintenance, UpdateMaintenanceResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfMaintenanceExists(id);
        repository.deleteById(id);
        sendKafkaMaintenanceDeletedEvent(id);
    }

    @Override
    public UpdateMaintenanceResponse complete(UUID id) {
        rules.checkIfMaintenanceExists(id);
        rules.checkIfMaintenanceCompleted(id);
        var maintenance = repository.findById(id).orElseThrow();
        maintenance.setEndDate(LocalDateTime.now());
        sendKafkaMaintenanceCompletedEvent(maintenance.getCarId());

        var response = mapper.forResponse().map(maintenance, UpdateMaintenanceResponse.class);
        return response;
    }

    public void sendKafkaMaintenanceCreatedEvent(UUID carId) {
        producer.sendMessage(new MaintenanceCreatedEvent(carId), "maintenance-created");
    }

    public void sendKafkaMaintenanceDeletedEvent(UUID id) {
        var carId = repository.findById(id).orElseThrow().getCarId();
        producer.sendMessage(new MaintenanceDeletedEvent(carId), "maintenance-deleted");
    }

    private void sendKafkaMaintenanceCompletedEvent(UUID carId) {
        producer.sendMessage(new MaintenanceCompletedEvent(carId), "maintenance-completed");
    }
}
