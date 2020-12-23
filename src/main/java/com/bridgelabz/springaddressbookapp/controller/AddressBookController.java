package com.bridgelabz.springaddressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{bookId}")
	public ResponseEntity<String> getAddressBookDataById(@PathVariable("bookId") int bookId) {
		return new ResponseEntity<String>("Get Call Success for id: " + bookId, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Created address Book Data for: " + addressBookDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated address Book Data for: " + addressBookDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("bookId") int bookId) {
		return new ResponseEntity<String>("Delete Call Success for id: " + bookId, HttpStatus.OK);
	}

}
