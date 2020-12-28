package com.bridgelabz.springaddressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$", message = "Invalid name")
	public String name;

	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid phone number")
	public String phoneNumber;

	@NotEmpty(message = "Address cannot be null")
	public String address;

	public String city;

	public String state;

	public String zip;

}
