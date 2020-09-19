package com.ducat.springboot.swagger.vo;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public class CustomerReadingRes {

	private String userName;
	private String cityName;
	List<DistrictWiseReadingRes> district;
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
	 * @return the district
	 */
	public List<DistrictWiseReadingRes> getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(List<DistrictWiseReadingRes> district) {
		this.district = district;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
