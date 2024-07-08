package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
