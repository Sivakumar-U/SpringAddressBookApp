package com.bridgelabz.springaddressbookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.dto.ResponseDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBookData;
import com.bridgelabz.springaddressbookapp.service.IAddressBookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	@RequestMapping(value = "/get")
	@ApiOperation("To get the contacts")
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookData = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contId}")
	@ApiOperation("To get the contacts By Id")
	public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("contId") int contId) {
		AddressBookData addressBookData = addressBookService.getAddressBookById(contId);
		ResponseDTO responseDTO = new ResponseDTO("Successfully got the data ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("city") String city) {
		List<AddressBookData> bookDataList = null;
		bookDataList = addressBookService.getAddressBookDataByCity(city);
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful For City", bookDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	@ApiOperation("To create the contact")
	public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Successfully created the data ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contId}")
	@ApiOperation("To update the contact")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@Valid @PathVariable("contId") int contId,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookService.updateAddressBookData(contId, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated address book of Id : ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contId}")
	@ApiOperation("To delete the contact")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contId") int contId) {
		addressBookService.deleteAddressBookData(contId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully the contact ", contId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
