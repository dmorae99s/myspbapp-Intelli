package com.trainingtcs.myspbapp.repository;

import com.trainingtcs.myspbapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
