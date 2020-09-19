package com.ducat.springboot.swagger.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ducat.springboot.swagger.model.DistrictDetails;

@Repository
public interface DistrictDAO extends JpaRepository<DistrictDetails, Long>{

public List<DistrictDetails> findDistrictDetailsByDistrictName(String districtName);

@Query("FROM DistrictDetails g where g.city.cityId = :id AND g.districtName = :disctrictName")
public DistrictDetails findByCityIdAndDistrictName(@Param("id") Long id,@Param("disctrictName") String disctrictName);
}
