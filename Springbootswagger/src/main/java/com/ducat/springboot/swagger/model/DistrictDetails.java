package com.ducat.springboot.swagger.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "DISTRICT")
public class DistrictDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DISTRICT_ID")
	private Long districtId;

	@Column(name = "DISTRICT_NAME")
	private String districtName;
	
	@Column(name = "INSTALL_DATE")
	private Date installDate;

	@Column(name = "SENSOR_ID")
	private Long sensorId;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CITY_ID", insertable = false, updatable = false)
	@JsonIgnore
	private CityDetails city;

	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 *            the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the cityId
	 */

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName
	 *            the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	

	/**
	 * @return the installDate
	 */
	public Date getInstallDate() {
		return installDate;
	}

	/**
	 * @param installDate the installDate to set
	 */
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
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

	/**
	 * @return the city
	 */
	public CityDetails getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(CityDetails city) {
		this.city = city;
	}


}
