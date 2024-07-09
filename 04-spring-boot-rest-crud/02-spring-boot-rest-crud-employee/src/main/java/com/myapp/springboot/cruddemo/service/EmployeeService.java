package com.myapp.springboot.cruddemo.service;


import com.myapp.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
