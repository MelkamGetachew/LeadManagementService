package com.craft.leadmanagementservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.model.Leads;


@Repository
public interface LeadRepository extends JpaRepository <Leads,String>   {

}
