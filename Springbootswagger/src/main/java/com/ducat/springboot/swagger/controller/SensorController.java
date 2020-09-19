package com.ducat.springboot.swagger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ducat.springboot.swagger.service.SensorService;
import com.ducat.springboot.swagger.vo.CustomerReadingRes;
import com.ducat.springboot.swagger.vo.ReadingRequestVO;

/**
 * @author Lenovo
 *
 */
@RestController
@RequestMapping(value = "/sensorApp")
public class SensorController {

	
	@Autowired
	SensorService sensorService;

	/**
	 * @param readingRequestVO
	 * @return
	 */
	@PostMapping(value = "/saveReadingdata")
	public ResponseEntity<?> saveRadingdata(@RequestBody ReadingRequestVO readingRequestVO) {
		try {
			sensorService.saveSensordata(readingRequestVO);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

	/**
	 * @param userName
	 * @param cityName
	 * @param districtName
	 * @return
	 */
	@GetMapping(value = "/filterReadingData/{userName}/{cityName}/{districtName}")
	public ResponseEntity<CustomerReadingRes> filterReadingData(@Valid @PathVariable("userName") String userName,
			@Valid @PathVariable("cityName") String cityName,
			@Valid @PathVariable("districtName") String districtName) {
		try {
			CustomerReadingRes response = sensorService.getReadingDataByFilters(userName, cityName, districtName);
			if (ObjectUtils.isEmpty(response)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

}