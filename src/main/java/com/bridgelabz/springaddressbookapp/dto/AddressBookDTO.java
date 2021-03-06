package com.bridgelabz.springaddressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Invalid name")
	public String name;

	// @Pattern(regexp="^(?=.*\\s)(?=.*[,])[A-Za-z0-9]{3,}[A-Za-z0-9\\s,]{1,}$",
	// message="Invalid address")
	@NotEmpty(message = "Address cannot be null")
	public String address;
	
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid phone number")
	@NotEmpty(message = "Mobile number cannot be null")
	public String mobile;

	@NotBlank(message = "City should not be empty")
	public String city;

	@NotBlank(message = "State should not be empty")
	public String state;

	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$", message = "Invalid zip code")
	public String zip;

}
