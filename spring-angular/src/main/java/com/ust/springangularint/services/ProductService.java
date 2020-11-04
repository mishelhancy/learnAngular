package com.ust.springangularint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ust.springangularint.entities.Product;
import com.ust.springangularint.entities.ProductDetails;

import com.ust.springangularint.repos.ProductJpaRepo;







@Service
public class ProductService {
	@Autowired
//	EmployeeRepository employeeRepository;
	ProductJpaRepo productRepository;
	


	public List<Product> fetchAllProducts() {
		// get list of data from storage
//		return employeeRepository.findAllEmployees();
		return productRepository.findAll();
//		return employeeMongoRepository.findAll();
		
	}

	public void addProduct(Product input) {
//		if(input.id == already exists), throw an exception
//		if(employeeRepository.findById(input.id)){
//			throw new RuntimeException("Id already exists");
//		}
		
		productRepository.save(input);
//		employeeMongoRepository.save(input);
	}

	public Product findProductById(int id) {
		Optional<Product> emp = productRepository.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		return null;
	}

	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}

	public boolean findByName(String name) {
		Product emp = productRepository.findByName(name);
//		emp.getAddresses();
		System.out.println("my emp"+emp);
		if(emp==null){
			return false;
		}
		return true;
	}
	
	public List<ProductDetails> fetchDetailsById(int id) {
		// get list of data from storage
		
		Optional<Product> emp = productRepository.findById(id);
	
		if(emp.isPresent()){
			Product emp2=emp.get();
			List<ProductDetails> add= emp2.productDetails;
			return add;
			
		}
		
		return null;
		
	}

//	public Double fetchTotalPrice() {
//		return productRepository.findTotalSalary();
//	}

//	public void addAddress(Address address) {
//		// TODO Auto-generated method stub
//		addressRepository.save(address);
//	}
//	

}
