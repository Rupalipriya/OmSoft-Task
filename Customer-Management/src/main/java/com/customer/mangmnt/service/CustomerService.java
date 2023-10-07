package com.customer.mangmnt.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.customer.mangmnt.entity.Customer;
import com.customer.mangmnt.entity.Revenue;

public interface CustomerService {
	
	List<Revenue> importExcelData(MultipartFile readExcelDataFile) throws IOException;
	

}
