package com.craft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String notes;
	private String birthday;
	private String company;
}
