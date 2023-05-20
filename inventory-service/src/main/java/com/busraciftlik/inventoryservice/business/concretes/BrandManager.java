package com.busraciftlik.inventoryservice.business.concretes;

import com.busraciftlik.common.events.inventory.BrandDeletedEvent;
import com.busraciftlik.common.kafka.producer.KafkaProducer;
import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.inventoryservice.business.abstracts.BrandService;
import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetBrandResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import com.busraciftlik.inventoryservice.business.rules.BrandBusinessRules;
import com.busraciftlik.inventoryservice.entities.Brand;
import com.busraciftlik.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository repository;
    private final ModelMapperService mapper;
    private final BrandBusinessRules rules;
    private final KafkaProducer producer;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> responses = brands
                .stream()
                .map(brand -> mapper.forResponse().map(brand, GetAllBrandsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetBrandResponse getByI(UUID id) {
        rules.checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(brand, GetBrandResponse.class);
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand = mapper.forRequest().map(request, Brand.class);
        repository.save(brand);

        return mapper.forResponse().map(brand, CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);
        Brand brand = mapper.forRequest().map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);

        return mapper.forResponse().map(brand, UpdateBrandResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
        sendKafkaBrandDeletedEvent(id);

    }
    private void sendKafkaBrandDeletedEvent(UUID id){
        producer.sendMessage(new BrandDeletedEvent(id),"brand-deleted");
    }

}
