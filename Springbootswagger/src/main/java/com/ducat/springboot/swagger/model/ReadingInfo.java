package com.ducat.springboot.swagger.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "READING")
public class ReadingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "READING_ID")
	private Long readingId;

	@Column(name = "CO2_LEVEL")
	private String co2Level;
	
	@Column(name = "UPDATED_AT")
	private Date readingTime;

	@Column(name = "SENSOR_ID")
	private Long sensorId;

	/**
	 * @return the readingId
	 */
	public Long getReadingId() {
		return readingId;
	}

	/**
	 * @param readingId
	 *            the readingId to set
	 */
	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	
	/**
	 * @return the sensorId
	 */
	public Long getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @return the co2Level
	 */
	public String getCo2Level() {
		return co2Level;
	}

	/**
	 * @param co2Level
	 *            the co2Level to set
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
	 * @param readingTime
	 *            the readingTime to set
	 */
	public void setReadingTime(Date readingTime) {
		this.readingTime = readingTime;
	}

}
