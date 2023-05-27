package com.busraciftlik.invoiceservice.business.abstracts;

import com.busraciftlik.invoiceservice.business.dto.responses.GetAllInvoicesResponse;
import com.busraciftlik.invoiceservice.business.dto.responses.GetInvoiceResponse;
import com.busraciftlik.invoiceservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(String id);

    void add(Invoice invoice);

    //void update(String id, Invoice invoice);

    void delete(String id);

}
