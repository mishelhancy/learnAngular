package com.ust.springangularint.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ust.springangularint.entities.ProductDetails;


public interface ProductDetailsJpaRepo extends JpaRepository<ProductDetails, Integer> {

}
