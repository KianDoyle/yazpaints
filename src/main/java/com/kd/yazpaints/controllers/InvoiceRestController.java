package com.kd.yazpaints.controllers;

import com.kd.yazpaints.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/invoice")
public class InvoiceRestController {

    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateInvoice(@RequestBody String invoiceJson) {
        return ResponseEntity.ok(invoiceService.generateInvoice(invoiceJson));
    }
}
