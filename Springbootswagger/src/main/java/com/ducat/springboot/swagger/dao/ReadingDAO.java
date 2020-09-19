package com.ducat.springboot.swagger.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ducat.springboot.swagger.model.ReadingInfo;

@Repository
public interface ReadingDAO extends JpaRepository<ReadingInfo, Long>{
	
	public List<ReadingInfo> findReadingInfoBySensorId(Long sensorId);
	
	

}
