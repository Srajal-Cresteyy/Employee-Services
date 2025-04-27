package com.srajaldwivedi.employee.mapper;

import com.srajaldwivedi.employee.dto.EmployeeDetailsDto;
import com.srajaldwivedi.employee.dto.EmployeeDto;
import com.srajaldwivedi.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToCustomerDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        return employeeDto;
    }

    public static Employee mapToCustomer(EmployeeDto employeeDto, Employee employee) {
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        return employee;
    }

    public static EmployeeDetailsDto mapToCustomerDetailsDto(Employee employee, EmployeeDetailsDto employeeDetailsDto) {
        employeeDetailsDto.setName(employee.getName());
        employeeDetailsDto.setEmail(employee.getEmail());
        employeeDetailsDto.setMobileNumber(employee.getMobileNumber());
        return employeeDetailsDto;
    }
}