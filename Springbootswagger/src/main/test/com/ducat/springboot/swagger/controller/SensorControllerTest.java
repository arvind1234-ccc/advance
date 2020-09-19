package com.ducat.springboot.swagger.controller;



import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

import com.ducat.springboot.swagger.dao.ReadingDAO;
import com.ducat.springboot.swagger.model.ReadingInfo;
import com.ducat.springboot.swagger.service.SensorService;

public class SensorControllerTest {

	
	@Mock
	ReadingDAO readingDAO;
	
	@InjectMocks
	SensorService sensorService;
	
	
	@Before
    public void init() {
		 MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testSaveRadingdata() throws Exception {
		ReadingInfo radingInfo = new ReadingInfo();
		radingInfo.setCo2Level("54");
		radingInfo.setReadingTime(new Date());
		radingInfo.setSensorId(new Long(123));
		verify(readingDAO, times(1)).save(radingInfo);
	}
	

}
