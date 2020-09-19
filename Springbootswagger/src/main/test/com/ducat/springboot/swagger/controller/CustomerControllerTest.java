package com.ducat.springboot.swagger.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import com.ducat.springboot.swagger.dao.CustomerDAO;
import com.ducat.springboot.swagger.model.CustomerDetails;
import com.ducat.springboot.swagger.service.CustomerService;
import com.ducat.springboot.swagger.vo.CustomerAddRequest;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;
	
	@Mock
	CustomerDAO customerDao;
	
	@InjectMocks
	CustomerController customerController;
	
	@Before
    public void init() {
		 MockitoAnnotations.initMocks(this);
    }
	
	
	@Test
	public void testAddCustomer() throws Exception {
		CustomerAddRequest customerModel = new CustomerAddRequest();
		customerModel.setCustomerName("Arvind");
		customerModel.setUserName("Arv123");
		customerModel.setPassword("Arv123");
		verify(customerService, times(1)).saveCustomer(customerModel);
	}

	@Test
	public void testfindByUserName(){
		CustomerDetails customerModel = new CustomerDetails();
		customerModel.setCustName("Arvind");
		customerModel.setUserName("Arv123");
		customerModel.setPassword("Arv123");
		when(customerDao.findCustomerByUserName("Arv123")).thenReturn(customerModel);
		CustomerDetails customerModelNew = customerDao.findCustomerByUserName("Arv123");
		assertEquals("Arvind", customerModelNew.getCustName());
		assertEquals("Arv123", customerModelNew.getUserName());
		assertEquals("Arv123", customerModelNew.getPassword());
	}
	
	@Test
	public void testUpdateCustomer() {
		CustomerDetails customerModel = new CustomerDetails();
		customerModel.setCustName("Arvind");
		customerModel.setUserName("Arv123");
		customerModel.setPassword("Arv123");
		when(customerDao.findCustomerByUserName("Arv123")).thenReturn(customerModel);
		
		
		/*CustomerDetails customerModelNew = customerDao.findCustomerByUserName("Arv123");
		assertEquals("Arvind", customerModelNew.getCustName());
		assertEquals("Arv123", customerModelNew.getUserName());
		assertEquals("Arv123", customerModelNew.getPassword());

		customerModelNew.setCustName("Nibish");

		verify(customerDao, times(1)).save(customerModel);*/
	}
		
	

	@Test
	public void testLoginCustomer() {
		CustomerDetails customerModel = new CustomerDetails();
		customerModel.setUserName("Arv123");
		customerModel.setPassword("Arv123");
		when(customerDao.findCustomerByUserName("Arv123")).thenReturn(customerModel);
		
		CustomerDetails customerModelNew = customerDao.findCustomerByUserName("Arv123");
		assertEquals("Arv123", customerModelNew.getUserName());
		assertEquals("Arv123", customerModelNew.getPassword());
	}

}
