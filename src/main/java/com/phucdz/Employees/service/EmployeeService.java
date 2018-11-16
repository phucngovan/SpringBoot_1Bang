package com.phucdz.Employees.service;

import com.phucdz.Employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    void remove(Long id);
    Employee findById(Long id);
    Page<Employee> findByName(String name,Pageable pageable);

}
