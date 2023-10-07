package com.customer.mangmnt.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.customer.mangmnt.entity.Customer;
import com.customer.mangmnt.entity.Revenue;
import com.customer.mangmnt.repo.CustomerRepo;
import com.customer.mangmnt.service.CustomerService;

import scala.collection.parallel.ParIterableLike.Foreach;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Revenue> importExcelData(MultipartFile readExcelDataFile) throws IOException {
		 List<Customer> customerList = new ArrayList<Customer>();
		    XSSFWorkbook workbook = new XSSFWorkbook(readExcelDataFile.getInputStream());
		    XSSFSheet worksheet = workbook.getSheetAt(0);
		    Customer customer = new Customer();
		    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		        
		            
		        XSSFRow row = worksheet.getRow(i);
		            
		        customer.setCustomerId((int) row.getCell(0).getNumericCellValue());
		        customer.setCustomerName(row.getCell(1).getStringCellValue());
		        customer.setProductName(row.getCell(2).getStringCellValue());
		        customer.setProductPrice((double) row.getCell(3).getNumericCellValue());
		        customer.setQtySold((double) row.getCell(4).getNumericCellValue());
		        customerList.add(customer); 
		        customerList=    customerRepo.saveAll(customerList);
		    }
		  List<Revenue> revenueList=  calculateRevenue(customerList);
		return revenueList;
	}

	public List<Revenue> calculateRevenue(List<Customer> customerList) {
		List<Revenue> revenues=new ArrayList<>();
		
		Double totalRev=0.0;
		for (Customer customer : customerList) {
			Revenue revenue=new Revenue();
			totalRev=customer.getProductPrice()*customer.getQtySold();
			revenue.setCustomerId(customer.getCustomerId());
			revenue.setCustomerName(customer.getCustomerName());
			revenue.setTotalRevenue(totalRev);
			revenues.add(revenue);
		}
		return	revenues.stream().sorted(Comparator.comparing(Revenue::getTotalRevenue).reversed())
		.collect(Collectors.toList());
	}

	
	
}
