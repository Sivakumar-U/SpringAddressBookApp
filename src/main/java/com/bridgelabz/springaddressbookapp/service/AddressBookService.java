package com.bridgelabz.springaddressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();
		addressBookList.add(new AddressBookData(1, new AddressBookDTO("Sivakumar", "Tirupati")));
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		AddressBookData addressBookData = new AddressBookData(1, new AddressBookDTO("Sivakumar", "Tirupati"));
		return addressBookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int contId) {
		// TODO Auto-generated method stub

	}

}
