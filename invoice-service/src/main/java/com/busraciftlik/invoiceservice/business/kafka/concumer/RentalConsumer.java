package com.busraciftlik.invoiceservice.business.kafka.concumer;

import com.busraciftlik.common.events.invoice.InvoiceCreatedEvent;
import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.invoiceservice.business.abstracts.InvoiceService;
import com.busraciftlik.invoiceservice.entities.Invoice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RentalConsumer {
    private final InvoiceService service;
    private final ModelMapperService mapper;

    @KafkaListener(topics = "invoice-created",groupId = "rental-invoice-created")
    public void consume(InvoiceCreatedEvent event){
        Invoice invoice = mapper.forRequest().map(event, Invoice.class);
        service.add(invoice);
        log.info("invoice-created {}",event);
    }
}
