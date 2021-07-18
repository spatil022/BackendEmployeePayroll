package com.bl.employeepayrollapp.Repository;

import com.bl.employeepayrollapp.Model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, UUID> {

    Optional<EmployeePayrollData> findByName(String name);
}