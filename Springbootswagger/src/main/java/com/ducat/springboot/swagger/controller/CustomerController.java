package com.ducat.springboot.swagger.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ducat.springboot.swagger.service.CustomerService;
import com.ducat.springboot.swagger.util.VOConverterUtil;
import com.ducat.springboot.swagger.vo.CustomerAddRequest;
import com.ducat.springboot.swagger.vo.CustomerUpdateRequest;
import com.ducat.springboot.swagger.vo.LoginVO;
//customer controller
//missed
@RestController
@RequestMapping(value = "/sensorApp")
public class CustomerController {

	@Autowired
	VOConverterUtil voConverterUtil;

	@Autowired
	CustomerService customerService;

	/**
	 * @param customerDetails
	 * @return
	 */
	@PostMapping(value = "/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerAddRequest customerDetails) {

		if (StringUtils.isEmpty(customerDetails.getUserName())
				|| StringUtils.isEmpty(customerDetails.getPassword())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			customerService.saveCustomer(customerDetails);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

	/**
	 * @param customerUpdateRequest
	 * @return
	 */
	@PutMapping(value = "/updateCustomer/{userName}")
	public ResponseEntity<CustomerUpdateRequest> updateCustomer(@PathVariable("userName") String userName,
			@RequestBody CustomerUpdateRequest customerUpdateRequest) {
		
		if(StringUtils.isEmpty(userName)){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			boolean flag = customerService.isCustomerPresent(userName);
			if (flag) {
				customerService.updateCustomer(customerUpdateRequest,userName);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

	/**
	 * @param loginVO
	 * @return
	 */
	@PostMapping(value = "/loginCustomer")
	public ResponseEntity<List<?>> loginCustomer(@RequestBody LoginVO loginVO) {
		
		if (StringUtils.isEmpty(loginVO.getUserName())
				|| StringUtils.isEmpty(loginVO.getPassword())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		try {
			if (customerService.isCustomerAuthorize(loginVO.getUserName(), loginVO.getPassword())) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

	}

}
