package com.ust.springangularint.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ust.springangularint.entities.Product;


public interface ProductJpaRepo extends JpaRepository<Product, Integer>{
	
	public Product findByName(String name);
	
//	@Query("select sum(e.salary) from Employee e")
//	public Double findTotalSalary();

}
