package com.ducat.springboot.swagger.vo;

import java.util.Date;

/**
 * @author Lenovo
 *
 */
public class ReadingResponseVO {

	private String co2Level;
	private Date readingTime;
	private Long sensorId;
	/**
	 * @return the co2Level
	 */
	public String getCo2Level() {
		return co2Level;
	}
	/**
	 * @param co2Level the co2Level to set
	 */
	public void setCo2Level(String co2Level) {
		this.co2Level = co2Level;
	}
	/**
	 * @return the readingTime
	 */
	public Date getReadingTime() {
		return readingTime;
	}
	/**
	 * @param readingTime the readingTime to set
	 */
	public void setReadingTime(Date readingTime) {
		this.readingTime = readingTime;
	}
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
	
	
}
