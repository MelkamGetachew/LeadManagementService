package com.craft.service;

import com.craft.model.Leads;

public interface LeadService {
	 	void createLead(Leads lead);
	    void convertLeadToCustomer(String leadId);
}
