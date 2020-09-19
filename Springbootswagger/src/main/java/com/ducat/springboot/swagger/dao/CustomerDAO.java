package com.ducat.springboot.swagger.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.springboot.swagger.model.CustomerDetails;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerDetails, Long>{

public CustomerDetails findCustomerByUserName(String userName);

}
