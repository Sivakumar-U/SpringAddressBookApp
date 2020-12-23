package com.bridgelabz.springaddressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$", message = "Invalid name")
	public String name;

	@Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "Address is Invalid!!! ")
	@NotEmpty(message = "Address cannot be null")
	public String address;

	public AddressBookDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressBookDTO [name=" + name + ", address=" + address + "]";
	}
}
