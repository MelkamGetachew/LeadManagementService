package com.craft.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.craft.leadmanagementservice.LeadRepository;
import com.craft.model.Customer;
import com.craft.model.Leads;
@Service
public class LeadServiceImp implements LeadService {
	@Autowired
	public LeadRepository leadRepository;
	@Autowired
	RestTemplate restTemplate;
	@Override
	public void createLead(Leads lead) {
		String id = generateRandomId();
		lead.setLeadId(id);
		leadRepository.save(lead);
	}
	
	public String generateRandomId() {
		Random random = new Random();
		String id;
		while(true) {
		 int randomNumber = random.nextInt(10000001);
		  id = "Lead" + randomNumber;
		 Optional<Leads> leadList =  leadRepository.findById(id);

		 if (leadList.isEmpty()) {
			 break;
		 }
		}
		 return id;
	}
	@Override
	public void convertLeadToCustomer(String leadId) {
		Optional<Leads> leadList = leadRepository.findById(leadId);
		Leads lead = null;
		if (leadList.isPresent()) {
			lead = leadList.get();
		}
		Customer customer = new Customer();
		customer.setFirstName(lead.getFirstName());
		customer.setLastName(lead.getLastName());
		customer.setEmail(lead.getEmail());
		customer.setPhoneNumber(lead.getPhoneNumber());
		String url = "http://localhost:8080/customers/create";
		Customer customer1 = restTemplate.postForObject(url,customer, Customer.class);
		leadRepository.delete(lead);
	}

}
