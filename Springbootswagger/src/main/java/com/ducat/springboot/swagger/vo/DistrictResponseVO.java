package com.ducat.springboot.swagger.vo;

import java.util.Date;

/**
 * @author Lenovo
 *
 */
public class DistrictResponseVO {

	private Long sensorId;
	private String districtName;
	private Date installationDate;
	/**
	 * @return the sensorId
	 */
	public Long getSensorId() {
		return sensorId;
	}
	/**
	 * @param sensorId the sensorId to set
	 */
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}
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
	 * @return the installationDate
	 */
	public Date getInstallationDate() {
		return installationDate;
	}
	/**
	 * @param installationDate the installationDate to set
	 */
	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}
	
	
	
}
