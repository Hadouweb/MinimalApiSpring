package com.hr.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.hr.api.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}