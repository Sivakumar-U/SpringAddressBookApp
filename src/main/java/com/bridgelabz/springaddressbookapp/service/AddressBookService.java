package com.bridgelabz.springaddressbookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.exceptions.AddressBookException;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import com.bridgelabz.springaddressbookapp.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	private List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		return addressBookList.stream().filter(bookData -> bookData.getAddressBookId() == contId).findFirst()
				.orElseThrow(() -> new AddressBookException("Addressbook entry Not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData bookData = null;
		bookData = new AddressBookData(addressBookDTO);
		addressBookList.add(bookData);
		log.debug("Addressbook Data :" + bookData.toString());
		return addressBookRepository.save(bookData);
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
