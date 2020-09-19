/**
 * 
 */
package com.ducat.springboot.swagger.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ducat.springboot.swagger.service.CityService;

/**
 * @author Lenovo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CityControllerTest {
	
	@Mock
	CityService cityService;
	
	@InjectMocks
	CityController cityController;
	
	@Before
    public void init() {
		 MockitoAnnotations.initMocks(this);
    }

	/**
	 * Test method for {@link com.ducat.springboot.swagger.controller.CityController#addCity(java.util.List)}.
	 */
	/*@Test
	public void testEditCity() {
		fail("Not yet implemented");
	}*/


}
