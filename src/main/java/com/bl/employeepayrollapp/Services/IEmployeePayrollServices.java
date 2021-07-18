package com.bl.employeepayrollapp.Services;



import com.bl.employeepayrollapp.Model.EmployeePayrollData;
import com.bl.employeepayrollapp.dto.EditPayrollDto;
import com.bl.employeepayrollapp.dto.EmployeePayrollDto;

import java.util.List;
import java.util.UUID;

public interface IEmployeePayrollServices {

    List<EmployeePayrollData> getAllUser();

    EmployeePayrollData getUserById(UUID employeeId);

    EmployeePayrollData CreateUser(EmployeePayrollDto employee);

    EmployeePayrollData updateById(EditPayrollDto user);

    EmployeePayrollData deleteById(UUID employeeId);
}
