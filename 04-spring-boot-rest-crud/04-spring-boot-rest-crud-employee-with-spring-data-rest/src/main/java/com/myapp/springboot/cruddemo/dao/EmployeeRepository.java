package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // no need to write code

}
