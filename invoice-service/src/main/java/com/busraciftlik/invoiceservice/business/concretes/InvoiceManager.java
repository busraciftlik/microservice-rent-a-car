package com.busraciftlik.invoiceservice.business.concretes;

import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.invoiceservice.business.abstracts.InvoiceService;
import com.busraciftlik.invoiceservice.business.dto.responses.GetAllInvoicesResponse;
import com.busraciftlik.invoiceservice.business.dto.responses.GetInvoiceResponse;
import com.busraciftlik.invoiceservice.entities.Invoice;
import com.busraciftlik.invoiceservice.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final InvoiceRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> all = repository.findAll();
        List<GetAllInvoicesResponse> responses = all
                .stream().map(invoice -> mapper.forResponse().map(invoice, GetAllInvoicesResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetInvoiceResponse getById(String id) {
        Invoice invoice = repository.findById(id).orElseThrow();

        return mapper.forResponse().map(invoice, GetInvoiceResponse.class);
    }

    @Override
    public void add(Invoice invoice) {
        invoice.setId(UUID.randomUUID().toString());
        repository.save(invoice);
    }

//    @Override
//    public void update(String id, Invoice invoice) {
//        //Invoice invoice1 = repository.findById(id).orElseThrow();
//        Invoice invoice1 = mapper.forResponse().map(invoice, Invoice.class);
//        invoice1.setId(id);
//
//        repository.save(invoice1);
//
//    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
