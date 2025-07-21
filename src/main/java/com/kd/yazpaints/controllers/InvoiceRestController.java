package com.kd.yazpaints.controllers;

import com.kd.yazpaints.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testController() {
        return ResponseEntity.ok("You've reached the invoices endpoint!");
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateInvoice(@RequestBody String invoiceJson) {
        return ResponseEntity.ok(invoiceService.generateInvoice(invoiceJson));
    }
}
