package com.phucdz.Employees.repository;

import com.phucdz.Employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
