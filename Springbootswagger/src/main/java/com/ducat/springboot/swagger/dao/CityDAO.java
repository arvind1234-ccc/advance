package com.ducat.springboot.swagger.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ducat.springboot.swagger.model.CityDetails;


@Repository
public interface CityDAO extends JpaRepository<CityDetails, Long>{

public CityDetails findCityDetailsByCityName(String cityName);

public CityDetails findCityDetailsByCityId(Long cityId);

@Query("FROM CityDetails g where g.customerDetails.userName = :userName AND g.cityName =:cityName")
public CityDetails findByUserNameAndCityName(@Param("userName") String userName,@Param("cityName") String cityName);

}
