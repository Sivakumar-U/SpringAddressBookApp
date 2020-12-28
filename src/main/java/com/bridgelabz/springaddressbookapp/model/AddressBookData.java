package com.bridgelabz.springaddressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name = "addressbook")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressBookId;
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String zip;

	public AddressBookData() {
	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		this.name = addressBookDTO.name;
		this.phoneNumber = addressBookDTO.phoneNumber;
		this.address = addressBookDTO.address;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip = addressBookDTO.zip;
	}

}
