/**
 * 
 */
package com.ducat.springboot.swagger.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import com.ducat.springboot.swagger.dao.CityDAO;
import com.ducat.springboot.swagger.dao.CustomerDAO;
import com.ducat.springboot.swagger.dao.DistrictDAO;
import com.ducat.springboot.swagger.dao.ReadingDAO;
import com.ducat.springboot.swagger.model.CityDetails;
import com.ducat.springboot.swagger.model.CustomerDetails;
import com.ducat.springboot.swagger.model.DistrictDetails;
import com.ducat.springboot.swagger.model.ReadingInfo;
import com.ducat.springboot.swagger.vo.CityRequestVO;
import com.ducat.springboot.swagger.vo.DistrictWiseReadingRes;
import com.ducat.springboot.swagger.vo.CustomerAddRequest;
import com.ducat.springboot.swagger.vo.CustomerReadingRes;
import com.ducat.springboot.swagger.vo.CustomerResponseVO;
import com.ducat.springboot.swagger.vo.CustomerUpdateRequest;
import com.ducat.springboot.swagger.vo.DistrictRequestVO;
import com.ducat.springboot.swagger.vo.ReadingRequestVO;
import com.ducat.springboot.swagger.vo.ReadingResponseVO;

/**
 * @author Lenovo
 *
 */
@Service
public class VOConverterUtil {

	@Autowired
	CustomerDAO customerDao;

	@Autowired
	DistrictDAO districtDAO;

	@Autowired
	CityDAO cityDAO;

	@Autowired
	ReadingDAO readingDAO;

	@Autowired
	CityDAO CityDAO;

	/**
	 * @param customerVO
	 * @return
	 */
	public CustomerDetails mapCustomerVOData(CustomerAddRequest customerVO) {
		CustomerDetails customerModel = new CustomerDetails();
		customerModel.setCustName(customerVO.getCustomerName());
		customerModel.setUserName(customerVO.getUserName());
		customerModel.setPassword(customerVO.getPassword());
		return customerModel;
	}

	/**
	 * @param customerVO
	 * @return
	 */
	public CustomerDetails mapUpdateCustomerRequest(CustomerUpdateRequest customerVO,String userName) {

		CustomerDetails customerModel = new CustomerDetails();
		CustomerDetails customerModelData = customerDao.findCustomerByUserName(userName);
		customerModel.setCustName(customerVO.getCustomerName());
		customerModel.setCustomerId(customerModelData.getCustomerId());
		customerModel.setPassword(customerVO.getPassword());
		return customerModel;
	}

	/**
	 * @param cityRequest
	 * @return
	 */
	public List<CityDetails> mapSaveORUpdateCity(List<CityRequestVO> cityRequest) {
		List<CityDetails> newList = new ArrayList<CityDetails>();
		List<DistrictDetails> districtModelList = new ArrayList<DistrictDetails>();
		if (!ObjectUtils.isEmpty(cityRequest)) {
			cityRequest.forEach(city -> {
				CityDetails CityDetails = new CityDetails();
				CityDetails cityDB = CityDAO.findByUserNameAndCityName(city.getUserName(), city.getCityName());
				if (!ObjectUtils.isEmpty(cityDB)) {
					CityDetails.setCityId(cityDB.getCityId());
				}
				CityDetails.setCityName(city.getCityName());
				CityDetails.setCustomerDetails(customerDao.findCustomerByUserName(city.getUserName()));
				List<DistrictRequestVO> district = city.getDistric();
				for (DistrictRequestVO dvo : district) {
					DistrictDetails districtModel = new DistrictDetails();
					districtModel.setDistrictName(dvo.getDistrictName());
					CityDetails details = CityDAO.findCityDetailsByCityName(city.getCityName());
					if (!ObjectUtils.isEmpty(cityDB)) {
						DistrictDetails dsDB = districtDAO.findByCityIdAndDistrictName(cityDB.getCityId(),
								dvo.getDistrictName());
						if (!ObjectUtils.isEmpty(dsDB)) {
							districtModel.setDistrictId(dsDB.getDistrictId());
						}
					}

					districtModel.setSensorId(dvo.getSensorId());
					districtModel.setInstallDate(dvo.getInstallationDate());

					districtModel.setCity(details);
					districtModelList.add(districtModel);

				}
				newList.add(CityDetails);
			});
		}

		CityDAO.saveAll(newList);
		districtDAO.saveAll(districtModelList);
		return newList;
	}

	/**
	 * @param list
	 * @return
	 */
	public List<CustomerResponseVO> mapDBCustomerData(List<CustomerDetails> list) {
		List<CustomerResponseVO> finalList = new ArrayList<CustomerResponseVO>();

		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(cust -> {
				CustomerResponseVO customerData = new CustomerResponseVO();
				customerData.setCustomerName(cust.getCustName());
				customerData.setUserName(cust.getUserName());
				finalList.add(customerData);
			});
		}

		return finalList;
	}

	/**
	 * @param list
	 * @return
	 */
	public CustomerResponseVO mapDBCustomerObject(CustomerDetails list) {
		CustomerResponseVO customerData = null;

		if (!ObjectUtils.isEmpty(list)) {

			customerData = new CustomerResponseVO();
			customerData.setCustomerName(list.getCustName());
			customerData.setUserName(list.getUserName());

		}

		return customerData;
	}

	/**
	 * @param list
	 * @return
	 */
	public List<ReadingResponseVO> mapReadingData(List<ReadingInfo> list) {
		List<ReadingResponseVO> finalList = new ArrayList<ReadingResponseVO>();
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(readingInfo -> {
				ReadingResponseVO res = new ReadingResponseVO();
				res.setCo2Level(readingInfo.getCo2Level());
				res.setSensorId(readingInfo.getSensorId());
				res.setReadingTime(readingInfo.getReadingTime());
				finalList.add(res);
			});
		}
		return finalList;
	}

	/**
	 * @param readingRequestVO
	 * @return
	 */
	public ReadingInfo mapReadingDataDB(ReadingRequestVO readingRequestVO) {

		ReadingInfo radingInfo = new ReadingInfo();

		radingInfo.setCo2Level(readingRequestVO.getCo2Level());
		radingInfo.setReadingTime(readingRequestVO.getReadingTime());
		radingInfo.setSensorId(readingRequestVO.getSensorId());
		return radingInfo;
	}

	/**
	 * @param userName
	 * @param cityName
	 * @param dName
	 * @return
	 */
	public CustomerReadingRes getReadingDataForFilter(String userName, String cityName, String dName) {
		List<DistrictWiseReadingRes> dList = new ArrayList<DistrictWiseReadingRes>();
		CustomerReadingRes readingData = new CustomerReadingRes();
		DistrictWiseReadingRes resultVO = new DistrictWiseReadingRes();
		CityDetails cityDetails = cityDAO.findByUserNameAndCityName(userName, cityName);
		DistrictDetails ds = districtDAO.findByCityIdAndDistrictName(cityDetails.getCityId(), dName);
		resultVO.setDistrictName(dName);
		resultVO.setResponseVO(mapReadingData(readingDAO.findReadingInfoBySensorId(ds.getSensorId())));
		dList.add(resultVO);
		readingData.setUserName(userName);
		readingData.setCityName(cityName);
		readingData.setDistrict(dList);

		return readingData;
	}
}
