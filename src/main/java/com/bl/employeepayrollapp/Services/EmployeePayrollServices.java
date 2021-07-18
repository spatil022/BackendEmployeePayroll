package com.bl.employeepayrollapp.Services;

import com.bl.employeepayrollapp.Exception.EmployeePayrollException;
import com.bl.employeepayrollapp.Model.EmployeePayrollData;
import com.bl.employeepayrollapp.Repository.EmployeePayrollRepository;
import com.bl.employeepayrollapp.dto.EditPayrollDto;
import com.bl.employeepayrollapp.dto.EmployeePayrollDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollServices implements IEmployeePayrollServices {

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getAllUser() {
        return employeePayrollRepository.findAll().
                stream().
                map(employeePayrollData -> new EmployeePayrollData(employeePayrollData)).
                collect(Collectors.toList());

    }

    @Override
    public EmployeePayrollData getUserById(UUID employeeId) {
        Optional<EmployeePayrollData> byId= employeePayrollRepository.findById(employeeId);
        if (!byId.isPresent()){
            throw new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }

        return new EmployeePayrollData(byId.get());
    }

    @Override
    public EmployeePayrollData CreateUser(EmployeePayrollDto employee) {

        Optional<EmployeePayrollData> byName= employeePayrollRepository.findByName(employee.getName());
        if (byName.isPresent()){
            throw new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_ALREADY_PRESENT);
        }

        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employee.getName(),
                employee.getSalary(),
                employee.getGender(),
                employee.getProfilePic(),
                employee.getDepartment(),
                employee.getStartDate(),
                employee.getNotes());

        return new EmployeePayrollData(employeePayrollRepository.save(employeePayrollData));
    }

    @Override
    public EmployeePayrollData updateById(EditPayrollDto user) {
        Optional<EmployeePayrollData> employeeDetails= employeePayrollRepository.findById(user.getEmployeeId());

        if (!employeeDetails.isPresent()){
            throw new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_PRESENT);
        }
        employeeDetails.get().setEmployeeId(user.getEmployeeId());
        employeeDetails.get().setName(user.getName());
        employeeDetails.get().setSalary(user.getSalary());
        employeeDetails.get().setGender(user.getGender());
        employeeDetails.get().setProfilePic(user.getProfilePic());
        employeeDetails.get().setDepartment(user.getDepartment());
        employeeDetails.get().setStartDate(user.getStartDate());
        employeeDetails.get().setNotes(user.getNotes());
        employeeDetails.get().setUpdatedAt(LocalDateTime.now());
        return new EmployeePayrollData(employeePayrollRepository.save(employeeDetails.get()));
    }

    @Override
    public EmployeePayrollData deleteById(UUID employeeId) {
        Optional<EmployeePayrollData> byId= employeePayrollRepository.findById(employeeId);
        if (!byId.isPresent()){
            throw new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
        employeePayrollRepository.deleteById(byId.get().getEmployeeId());
        return new EmployeePayrollData(byId.get());
    }

}