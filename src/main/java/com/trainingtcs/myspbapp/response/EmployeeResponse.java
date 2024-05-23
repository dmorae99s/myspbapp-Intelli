package com.trainingtcs.myspbapp.response;

public class EmployeeResponse {
    private int id;
    private String employeeName;
    private int userId;
    private DepartmentResponse department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public DepartmentResponse getDepartment() {
        return department;
    }
    public void setDepartment(DepartmentResponse department) {
        this.department = department;
    }
}
