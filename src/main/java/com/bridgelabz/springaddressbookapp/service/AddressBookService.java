package com.bridgelabz.springaddressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	private List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		return addressBookList.get(contId - 1);
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData bookData = null;
		bookData=new AddressBookData(addressBookList.size()+1,addressBookDTO);
		addressBookList.add(bookData);
		return bookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO) {
		AddressBookData bookData = this.getAddressBookById(contId);
		bookData.setName(addressBookDTO.name);
		bookData.setAddress(addressBookDTO.address);
		addressBookList.set(contId - 1, bookData);
		return bookData;
	}

	@Override
	public void deleteAddressBookData(int contId) {
		addressBookList.remove(contId - 1);
	}

}
