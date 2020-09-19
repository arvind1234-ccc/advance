package com.ducat.springboot.swagger.vo;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public class DistrictWiseReadingRes {
	
	private String districtName;
	List<ReadingResponseVO> responseVO;
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	/**
	 * @return the responseVO
	 */
	public List<ReadingResponseVO> getResponseVO() {
		return responseVO;
	}
	/**
	 * @param responseVO the responseVO to set
	 */
	public void setResponseVO(List<ReadingResponseVO> responseVO) {
		this.responseVO = responseVO;
	}
	
	

}
