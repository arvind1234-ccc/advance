package com.ducat.springboot.swagger.vo;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public class CustomerResponseVO {

	private String customerName;
	private String userName;
	private List<CityResponseVO> city;
	
    
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the city
	 */
	public List<CityResponseVO> getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(List<CityResponseVO> city) {
		this.city = city;
	}

	

	

	
}
