package com.trainingtcs.myspbapp.service;

import com.trainingtcs.myspbapp.entity.Department;
import com.trainingtcs.myspbapp.entity.Employee;
import com.trainingtcs.myspbapp.repository.DepartmentRepository;
import com.trainingtcs.myspbapp.repository.EmployeeRepository;
import com.trainingtcs.myspbapp.response.DepartmentResponse;
import com.trainingtcs.myspbapp.response.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository empRepo;
    private final ModelMapper mapper;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepo;

    //TODO: make a correct use of optional
    public EmployeeResponse getEmployeeById(int id) {
        return toEmployeeResponse.apply(empRepo.findById(id).orElse(null));
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = empRepo.findAll();
        return employees.stream().map(
                emp -> toEmployeeResponse.apply(emp) ).collect(Collectors.toList());

    }

    //
    public Map<String, EmployeeResponse> getMapEmployees() {

        class NameAndEmployee{
            String name;
            EmployeeResponse employeeResponse;

            public String getName() {
                return name;
            }
            public EmployeeResponse getEmployeeResponse() {
                return employeeResponse;
            }

            public NameAndEmployee(EmployeeResponse employeeResponse) {
                this.name = employeeResponse.getEmployeeName();
                this.employeeResponse = employeeResponse;

            }
        }

        List<Employee> employees = empRepo.findAll();
        Map<String, EmployeeResponse> mapEmp =
                employees.stream().map(emp->new NameAndEmployee(toEmployeeResponse.apply(emp))).
                        collect(Collectors.toMap(
                        NameAndEmployee::getName,NameAndEmployee::getEmployeeResponse
            ));

        return mapEmp;

    }

    public static Function<Employee, EmployeeResponse> toEmployeeResponse= employee -> {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setEmployeeName(employee.getEmployeeName());
        employeeResponse.setUserId(employee.getUserId());
        Department department = employee.getDepartment();
        DepartmentResponse departmentResponse = DepartmentService.toDepartmentResponse.apply(department);
        employeeResponse.setDepartment(departmentResponse);

        return employeeResponse;
    };


}
