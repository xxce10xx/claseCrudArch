package com.Bardalez.TareaAngular.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Bardalez.TareaAngular.Models.Employee;


public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT E FROM Employee E  WHERE E.age=:ageTemp")
    List<Employee> findByAge(@Param("ageTemp") byte age);
}
