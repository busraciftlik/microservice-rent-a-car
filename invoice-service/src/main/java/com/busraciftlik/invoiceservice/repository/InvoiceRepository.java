package com.busraciftlik.invoiceservice.repository;

import com.busraciftlik.invoiceservice.entities.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice,String> {

}
