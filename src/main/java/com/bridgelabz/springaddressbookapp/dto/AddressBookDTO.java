package com.bridgelabz.springaddressbookapp.dto;

public class AddressBookDTO {

	public String firstName;
	public String lastName;

	public AddressBookDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AddressBookDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
