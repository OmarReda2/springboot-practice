package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
