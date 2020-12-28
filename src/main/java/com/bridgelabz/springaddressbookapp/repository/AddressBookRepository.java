package com.bridgelabz.springaddressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.springaddressbookapp.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
