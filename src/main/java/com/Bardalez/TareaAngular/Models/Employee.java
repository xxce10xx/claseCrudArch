package com.Bardalez.TareaAngular.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "empleados")
public class Employee {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer id;
 
 @Column(name = "first_name")
 private String name;
 
 @Column(name = "last_name")
 private String lastName;
 
 @Column(name = "age")
 private byte age;
 
 public Employee(){}
 
 public Employee(String name, String last_name, byte age) {
	 this.name = name;
	 this.lastName = last_name;
	 this.age = age;
 }
 public Employee(int id, String name, String last_name, byte age) {
	 this.name = name;
	 this.lastName = last_name;
	 this.age = age;
	 this.id = id;
 }

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public byte getAge() {
	return age;
}

public void setAge(byte age) {
	this.age = age;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (id != other.id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Employees [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
}
 
 

}
