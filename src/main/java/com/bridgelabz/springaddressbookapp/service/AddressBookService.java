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

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		return addressBookRepository.findById(contId)
				.orElseThrow(() -> new AddressBookException("Addressbook entry Not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData bookData = null;
		bookData = new AddressBookData(addressBookDTO);
		log.debug("Addressbook Data :" + bookData.toString());
		return addressBookRepository.save(bookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO) {
		AddressBookData bookData = this.getAddressBookById(contId);
		bookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(bookData);
	}

	@Override
	public void deleteAddressBookData(int contId) {
		AddressBookData bookData = this.getAddressBookById(contId);
		addressBookRepository.delete(bookData);
	}

}
