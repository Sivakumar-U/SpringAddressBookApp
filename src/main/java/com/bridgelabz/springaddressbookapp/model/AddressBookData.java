package com.bridgelabz.springaddressbookapp.model;

import javax.persistence.Column;
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
	@Column(name = "id")
	public int id;
	public String name;
	public String address;
	public String mobile;
	public String city;
	public String state;
	public String zip;

	public AddressBookData() {
	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
		this.mobile = addressBookDTO.mobile;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip = addressBookDTO.zip;
	}

}
