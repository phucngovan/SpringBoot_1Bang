package com.phucdz.Employees.service.Impl;

import com.phucdz.Employees.model.Employee;
import com.phucdz.Employees.repository.EmployeeRepository;
import com.phucdz.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }
}
