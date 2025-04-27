package com.srajaldwivedi.employee.service.impl;

import com.srajaldwivedi.employee.dto.EmployeeDetailsDto;
import com.srajaldwivedi.employee.entity.Employee;
import com.srajaldwivedi.employee.exception.ResourceNotFoundException;
import com.srajaldwivedi.employee.mapper.EmployeeMapper;
import com.srajaldwivedi.employee.repository.EmployeeRepository;
import com.srajaldwivedi.employee.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Employee Details based on a given mobileNumber
     */
    @Override
    public EmployeeDetailsDto fetchCustomerDetails(String mobileNumber , String correlationId) {
        Employee employee = employeeRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "mobileNumber", mobileNumber)
        );

        EmployeeDetailsDto employeeDetailsDto = EmployeeMapper.mapToCustomerDetailsDto(employee, new EmployeeDetailsDto());

        return employeeDetailsDto;

    }
}
