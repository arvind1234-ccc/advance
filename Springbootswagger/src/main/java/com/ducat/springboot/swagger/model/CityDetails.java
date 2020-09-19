package com.ducat.springboot.swagger.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "CITY")
public class CityDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CITY_ID")
	private Long cityId;

	@Column(name = "CITY_NAME")
	private String cityName;

	/*@Column(name = "USER_NAME")
	private String userName;*/

	@OneToMany(mappedBy = "city", cascade = { CascadeType.ALL })
	private List<DistrictDetails> district=new ArrayList<DistrictDetails>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_NAME")
	@JsonIgnore
	private CustomerDetails customerDetails;

	/**
	 * @return the cityId
	 */
	public Long getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the customerDetails
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails
	 *            the customerDetails to set
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	/**
	 * @return the district
	 */
	public List<DistrictDetails> getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(List<DistrictDetails> district) {
		this.district = district;
	}

	/**
	 * @return the userName
	 *//*
	public String getUserName() {
		return userName;
	}

	*//**
	 * @param userName
	 *            the userName to set
	 *//*
	public void setUserName(String userName) {
		this.userName = userName;
	}*/

}
