package com.ducat.springboot.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ducat.springboot.swagger.dao.CustomerDAO;
import com.ducat.springboot.swagger.model.CustomerDetails;
import com.ducat.springboot.swagger.util.VOConverterUtil;
import com.ducat.springboot.swagger.vo.CustomerAddRequest;
import com.ducat.springboot.swagger.vo.CustomerResponseVO;
import com.ducat.springboot.swagger.vo.CustomerUpdateRequest;

/**
 * @author Lenovo
 *
 */
@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDao;
	

	@Autowired
	VOConverterUtil voConverterUtil;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public List<CustomerResponseVO> getAllCustomer() throws Exception{
		return voConverterUtil.mapDBCustomerData(customerDao.findAll());
	}
	
	
	/**
	 * @param customerDetails
	 * @throws Exception
	 */
	public void saveCustomer(CustomerAddRequest customerDetails) throws Exception{
		customerDao.save(voConverterUtil.mapCustomerVOData(customerDetails));
	}
	
	/**
	 * @param customerUpdateRequest
	 * @throws Exception
	 */
	public void updateCustomer(CustomerUpdateRequest customerUpdateRequest,String userName) throws Exception{
		  CustomerDetails custData=voConverterUtil.mapUpdateCustomerRequest(customerUpdateRequest,userName);
		  customerDao.save(custData);
	}
	
	/**
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public CustomerResponseVO findCustomerByUserName(String userName) throws Exception{
		return voConverterUtil.mapDBCustomerObject(customerDao.findCustomerByUserName(userName));
	}
	
	/**
	 * @param userName
	 * @return
	 */
	public boolean isCustomerPresent(String userName){
		CustomerResponseVO custData=voConverterUtil.mapDBCustomerObject(customerDao.findCustomerByUserName(userName));
		if(!ObjectUtils.isEmpty(custData)){
			return true;
		}
		return false;
	}
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomerAuthorize(String userName,String password) throws Exception{
		CustomerDetails custData=customerDao.findCustomerByUserName(userName);
		if(!ObjectUtils.isEmpty(custData)){
			if(custData.getPassword().equals(password)){
				return true;
			}
			
		}
		return false;
	}
}
