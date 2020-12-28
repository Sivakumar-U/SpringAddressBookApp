package com.bridgelabz.springaddressbookapp.service;

import java.util.List;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookById(int contId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO);

	void deleteAddressBookData(int contId);

	List<AddressBookData> getAddressBookDataByCity(String city);

}
