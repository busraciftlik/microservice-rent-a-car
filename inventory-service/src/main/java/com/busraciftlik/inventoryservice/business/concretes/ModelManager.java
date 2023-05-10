package com.busraciftlik.inventoryservice.business.concretes;

import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.inventoryservice.business.abstracts.ModelService;
import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateModelRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateModelRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateModelResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllModelsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetModelResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateModelResponse;
import com.busraciftlik.inventoryservice.business.rules.ModelBusinessRules;
import com.busraciftlik.inventoryservice.entities.Model;
import com.busraciftlik.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapperService mapper;
    private final ModelBusinessRules rules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> responses = models
                .stream()
                .map(model -> mapper.forResponse().map(model, GetAllModelsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetModelResponse getById(UUID id) {
        rules.checkIfModelExists(id);
        Model model = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(model, GetModelResponse.class);
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = mapper.forRequest().map(request, Model.class);
        repository.save(model);

        return mapper.forResponse().map(model, CreateModelResponse.class);
    }

    @Override
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {
        rules.checkIfModelExists(id);
        Model model = mapper.forRequest().map(request, Model.class);
        model.setId(id);
        repository.save(model);

        return mapper.forResponse().map(model, UpdateModelResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfModelExists(id);
        repository.deleteById(id);
    }
}
