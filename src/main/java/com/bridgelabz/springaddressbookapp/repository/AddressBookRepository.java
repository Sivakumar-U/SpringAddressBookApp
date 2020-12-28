package com.bridgelabz.springaddressbookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.springaddressbookapp.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

	@Query(value = "select * from addressbook where city=:city", nativeQuery = true)
	List<AddressBookData> getAddressBookDataByCity(String city);

}
