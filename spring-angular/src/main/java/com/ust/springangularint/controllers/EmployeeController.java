package com.ust.springangularint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ust.springangularint.entities.Product;
import com.ust.springangularint.entities.ProductDetails;

import com.ust.springangularint.services.ProductService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class EmployeeController {
	
	@Autowired
	ProductService productService;
	
//	@GetMapping("/totalsalary")
//	public Double fetchTotalSalaries(){
//		return employeeService.fetchTotalSalary();
//	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Product> fetchEmployee(@PathVariable("id")int id){
		System.out.println("In Fetch employee: " + id);
		
		ResponseEntity<Product> re = null; 
		Product product = productService.findProductById(id);
		if(product==null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return re;
		
		

	}
	
	
	@GetMapping("/details/{id}")
	public ResponseEntity<List<ProductDetails>>  ftechAllproductdetailsById(@PathVariable("id")int id){
		
		System.out.println("In Fetch details: " + id);
		
//		System.out.println(employeeService.fetchAllEmployeeById(id));
		List<ProductDetails> employee =productService.fetchDetailsById(id);
//		Address address =employeeService.a
		ResponseEntity<List<ProductDetails>> re = null; 
		
		if(employee==null) {
			
			re= new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		else {
			re= new ResponseEntity<List<ProductDetails>>(employee,HttpStatus.OK);
		}
		return re;

	
}
//	@DeleteMapping("/employees/{id}")
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
		
		ResponseEntity<String> re = null;
		try{
			productService.deleteProduct(id);
			re = ResponseEntity.ok().body("product has been deleted successfully.");
		}
		catch(EmptyResultDataAccessException e){
//			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//		
		return re;
	}
	@PutMapping("/")
	public ResponseEntity<Void> updateCourseOfEmployee(@RequestBody Product product){
		
		System.out.println("in PUUUTTTT");
		productService.addProduct(product);
		if(productService.findByName(product.name)){
			productService.addProduct(product);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		 
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/")
	public List<Product> fetchAllEmployee(){
		return productService.fetchAllProducts();
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> addEmployee(@RequestBody Product product){
//		if(employeeService.findByName(employee.name)){
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		
		productService.addProduct(product);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
//	@PostMapping("/address")
//	public ResponseEntity<Void> addAddress(@RequestBody ProductDetails productDetails){
//		System.out.println(productDetails);
////		address.setEmployee(employee)
//		
//		 employeeService.addAddress(productDetails);
//		 return new ResponseEntity<>(HttpStatus.CREATED);
//	}

}
