package com.ducat.springboot.swagger.vo;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public class CityResponseVO {

	private String cityName;
	
	private List<DistrictResponseVO> distric;

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
	public List<DistrictResponseVO> getDistric() {
		return distric;
	}

	/**
	 * @param distric the distric to set
	 */
	public void setDistric(List<DistrictResponseVO> distric) {
		this.distric = distric;
	}

	

	
	
	
}
