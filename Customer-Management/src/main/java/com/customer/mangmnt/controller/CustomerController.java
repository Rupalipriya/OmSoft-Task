package com.customer.mangmnt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.customer.mangmnt.entity.Customer;
import com.customer.mangmnt.entity.Revenue;
import com.customer.mangmnt.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	 

	@PostMapping(value="/importdata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<List<Revenue>> importExcelData(@RequestParam("file") MultipartFile readExcelDataFile) throws IOException {
	List<Revenue> customersList=	customerService.importExcelData(readExcelDataFile);
	    return new ResponseEntity<List<Revenue>>(customersList,HttpStatus.CREATED);
	}
	
}
