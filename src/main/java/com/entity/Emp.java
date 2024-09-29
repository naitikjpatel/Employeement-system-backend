package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String firstName;
	String lastName;
	String email;
	String address;
	Double salary;
}
