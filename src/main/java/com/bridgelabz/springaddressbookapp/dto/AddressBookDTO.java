package com.bridgelabz.springaddressbookapp.dto;

public class AddressBookDTO {

	public String fullName;
	public String address;

	public AddressBookDTO(String fullName, String address) {
		this.fullName = fullName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressBookDTO [fullName=" + fullName + ", address=" + address + "]";
	}
}
