package com.busraciftlik.invoiceservice.api.controllers;

import com.busraciftlik.invoiceservice.business.abstracts.InvoiceService;
import com.busraciftlik.invoiceservice.business.dto.responses.GetAllInvoicesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoicesController {
    private final InvoiceService service;
//    @PostConstruct
//    public void createDb(){
//        service.add(new Invoice());
//    }

    @GetMapping
    public List<GetAllInvoicesResponse> getAll(){
        return service.getAll();
    }
}
