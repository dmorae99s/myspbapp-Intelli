package com.trainingtcs.myspbapp.service;

import com.trainingtcs.myspbapp.entity.Department;
import com.trainingtcs.myspbapp.entity.Employee;
import com.trainingtcs.myspbapp.repository.DepartmentRepository;
import com.trainingtcs.myspbapp.repository.EmployeeRepository;
import com.trainingtcs.myspbapp.response.DepartmentResponse;
import com.trainingtcs.myspbapp.response.EmployeeResponse;
import com.trainingtcs.myspbapp.response.HRPaymentsResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.core.CompletionStageUtils;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository empRepo;
    private final ModelMapper mapper;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepo;

    private final WebClient.Builder webClientBuilder;

    private final DiscoveryClient discoveryClient;

    //TODO: Make the fallback method actually work
    @TimeLimiter(name = "employeeService", fallbackMethod = "hardcodedResponse")
    public List<HRPaymentsResponse> getEmployeePaymentsByEmpId(int empId) {

        List<ServiceInstance> eurekaServices = discoveryClient.getInstances("hr-services");
        if (eurekaServices == null || eurekaServices.isEmpty()) {
            return null;
        }

        String strUrl = eurekaServices.get(0).getUri().toString() +"/payments/" + empId;
        List<HRPaymentsResponse> hrPaymentsResponseList = webClientBuilder.baseUrl(strUrl).build().get().uri(strUrl ).retrieve().bodyToFlux(HRPaymentsResponse.class).collectList().block();

        return hrPaymentsResponseList;
    }
    public CompletionStage<List<HRPaymentsResponse>> hardcodedResponse(int empId, Exception e) throws Exception{
        //return "Something went very wrong, this is the error: " + empId + ", " + e.getMessage();
        System.out.println("Something went very wrong, this is the error: " + empId + ", " + e.getMessage());

        throw e;

    }

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
    public Map<String, List<Employee>> getMapEmployees() {

        List<Employee> employees = empRepo.findAll();
        Map<String, List<Employee>> mapEmp  =
                employees.stream().collect(
                        Collectors.groupingBy(emp->emp.getDepartment().getDepartmentName(), Collectors.toList()));

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
