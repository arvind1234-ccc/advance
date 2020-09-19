package com.ducat.springboot.swagger.vo;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public class CityRequestVO {

	private String cityName;
	private String userName;
	private List<DistrictRequestVO> distric;

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

	/**
	 * @return the distric
	 */
	public List<DistrictRequestVO> getDistric() {
		return distric;
	}

	/**
	 * @param distric the distric to set
	 */
	public void setDistric(List<DistrictRequestVO> distric) {
		this.distric = distric;
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

	
	
	
}
