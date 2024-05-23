package com.trainingtcs.myspbapp.repository;

import com.trainingtcs.myspbapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
}
