package com.Bardalez.TareaAngular.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Bardalez.TareaAngular.Models.Employee;
import com.Bardalez.TareaAngular.Repository.EmployeesRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class EmployeesController {
	
	@Autowired
	EmployeesRepository repository;
	
	@GetMapping(value = "/employee")
	public List<Employee> get(){
		List<Employee> employees = new ArrayList<>();
		repository.findAll().forEach(employees::add);
		return employees;
	}
	
	@GetMapping(value = "employee/{id}")
	public Optional<Employee> findById(@PathVariable("id") Integer id) {
		Optional<Employee> _employee = repository.findById(id);
		return _employee;
	}
	
	@GetMapping(value = "employee/age/{age}")
	public List<Employee> findByAge(@PathVariable byte age) {
		List<Employee> employees = repository.findByAge(age);
		return employees;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody Employee employee) {
		repository.save(new Employee(employee.getName(),employee.getLastName(),employee.getAge()));
		return new ResponseEntity<String>("ok", HttpStatus.OK);	
	}
	
	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody Employee employee) {
		Optional<Employee> _employee = repository.findById(employee.getId());
		if (_employee.isPresent()) {
			repository.save(employee);
			return new ResponseEntity<String>("ok", HttpStatus.OK);		
		} else {
			return new ResponseEntity<String>("error", HttpStatus.NOT_FOUND);
		} 
	}	
}
