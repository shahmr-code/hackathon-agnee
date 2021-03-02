package com.db.hackathon.onlineBanking.controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.db.hackathon.onlineBanking.model.CustomerDetails;
import com.db.hackathon.onlineBanking.service.BusinessService;
import com.db.hackathon.onlineBanking.service.FileUploadService;

@RestController
public class CustomerOnboardingController {

	@Autowired
	@Qualifier("BusinessServiceDataStore")
	private BusinessService businessService;

	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping("/message")
	public String greetMessage() {
		return "Hello, able to reach service";
	}
	
	@PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody CustomerDetails customerDetails) throws InterruptedException, ExecutionException {
		return businessService.createCustomer(customerDetails);
	}

	@GetMapping(value = "/getCustomerDetails")
	public CustomerDetails getCustomerDetails(@RequestParam String name) throws InterruptedException, ExecutionException {
		return businessService.getCustomerDetails(name);
	}

	@PutMapping(value = "/updateCustomerDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCustomerDetails(@RequestBody CustomerDetails CustomerDetails) throws InterruptedException, ExecutionException {
		return businessService.updateCustomerDetails(CustomerDetails);
	}

	@DeleteMapping(value = "/deleteCustomerDetails")
	public String deleteCustomerDetails(@RequestParam String name) {
		return businessService.deleteCustomerDetails(name);
	}
	
	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String  uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileUploadService.storeFile(file);
        System.out.println(fileName + " " + file.getContentType() + " "+ file.getSize() + " uploaded successfully");
        return fileName;
    }
	
	@PostMapping(value = "/uploadMultipleFiles", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }
}
