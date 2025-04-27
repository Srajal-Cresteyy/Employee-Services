package com.srajaldwivedi.employee.service;

import com.srajaldwivedi.employee.dto.EmployeeDetailsDto;

public interface IEmployeeService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Employee Details based on a given mobileNumber
     */
    EmployeeDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
