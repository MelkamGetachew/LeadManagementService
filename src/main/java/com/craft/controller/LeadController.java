package com.craft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.model.Leads;
import com.craft.service.LeadService;

@RestController
@RequestMapping("/leads")
public class LeadController {
	@Autowired
    private LeadService leadService;

    // Endpoint to create a new lead
    @PostMapping("/create")
    public ResponseEntity<?> createLead(@RequestBody Leads lead) {
        leadService.createLead(lead);
        return new ResponseEntity<>(lead, HttpStatus.CREATED);
    }

    // Endpoint to convert a lead to a customer
    @PutMapping("/convert/{leadId}")
    public ResponseEntity<?> convertLeadToCustomer(@PathVariable("leadId") String leadId) {
        leadService.convertLeadToCustomer(leadId);
        return new ResponseEntity<>("Lead converted to customer successfully", HttpStatus.OK);
    }
    
    @GetMapping("/convert/{leadId}")
    public void convertLeadToCustomerFromCustomerAPI(@PathVariable("leadId") String leadId) {
        leadService.convertLeadToCustomer(leadId);
    }
}
