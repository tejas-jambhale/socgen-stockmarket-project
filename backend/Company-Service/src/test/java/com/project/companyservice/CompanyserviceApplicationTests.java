package com.project.companyservice;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.companyservice.service.CompanyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

@SpringBootTest
class CompanyserviceApplicationTests {

	@Autowired
	CompanyService companyService;
	
	/*
	 * @Test void contextLoads() { }
	 */
	
	@Test
	public void testCompany() throws ClientProtocolException, IOException{
	 
	    // Given
		System.out.println( "hi");
		assertNotEquals(companyService.getAllCompanies(),null);
	    
	}

}
