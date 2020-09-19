package com.ducat.springboot.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ducat.springboot.swagger.dao.ReadingDAO;
import com.ducat.springboot.swagger.util.VOConverterUtil;
import com.ducat.springboot.swagger.vo.CustomerReadingRes;
import com.ducat.springboot.swagger.vo.ReadingRequestVO;
import com.ducat.springboot.swagger.vo.ReadingResponseVO;


@Service
public class SensorService {

	@Autowired
	ReadingDAO readingDAO;
	
	
	@Autowired
	VOConverterUtil voConverterUtil;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public List<ReadingResponseVO> getAllReadingData() throws Exception{ 
		return voConverterUtil.mapReadingData(readingDAO.findAll());
	}
	
	/**
	 * @param readingRequestVO
	 * @throws Exception
	 */
	public void saveSensordata(ReadingRequestVO readingRequestVO) throws Exception {
		synchronized (readingRequestVO) {
			readingDAO.save(voConverterUtil.mapReadingDataDB(readingRequestVO));
		}
		
	}
	
	/**
	 * @param userName
	 * @param cityName
	 * @param dName
	 * @return
	 * @throws Exception
	 */
	public CustomerReadingRes getReadingDataByFilters(String userName,String cityName,String dName) throws Exception {
		return voConverterUtil.getReadingDataForFilter(userName,cityName,dName);
	}
}
