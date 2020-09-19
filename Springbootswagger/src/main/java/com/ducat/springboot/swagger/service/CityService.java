package com.ducat.springboot.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ducat.springboot.swagger.dao.CityDAO;
import com.ducat.springboot.swagger.util.VOConverterUtil;
import com.ducat.springboot.swagger.vo.CityRequestVO;
/**
 * @author Lenovo
 *
 */
@Service
public class CityService {

	@Autowired
	CityDAO CityDAO;
	
	@Autowired
	VOConverterUtil voConverterUtil;
	
	/**
	 * @param cityRequest
	 * @throws Exception
	 */
	public void saveOrUpdateCity(List<CityRequestVO> cityRequest) throws Exception{
		voConverterUtil.mapSaveORUpdateCity(cityRequest);
		
	}
	
}
