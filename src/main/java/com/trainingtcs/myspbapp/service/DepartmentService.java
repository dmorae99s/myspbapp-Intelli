package com.trainingtcs.myspbapp.service;
import com.trainingtcs.myspbapp.entity.Department;
import com.trainingtcs.myspbapp.repository.DepartmentRepository;
import com.trainingtcs.myspbapp.response.DepartmentResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;


    public DepartmentResponse getDepartmentById(int id) {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Department department = optionalDepartment.get();

        return toDepartmentResponse.apply(department);
    }

    public static Function<Department, DepartmentResponse> toDepartmentResponse = department-> {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setId(department.getId());
        departmentResponse.setManagerName(department.getManagerName());

        return departmentResponse;
    };
}
