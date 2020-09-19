package com.ducat.springboot.swagger.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ducat.springboot.swagger.service.CityService;
import com.ducat.springboot.swagger.vo.CityRequestVO;

/**
 * @author Lenovo
 *
 */

//added here
@RestController
@RequestMapping(value = "/sensorApp")
public class CityController {

	@Autowired
	CityService cityService;
	
	
	/**
	 * @param customerDetails
	 * @return
	 */
	@PostMapping(value = "/editCity")
	public ResponseEntity<?> editCity(@RequestBody List<CityRequestVO> cityVO) {

		try {
			cityService.saveOrUpdateCity(cityVO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}
	
}
