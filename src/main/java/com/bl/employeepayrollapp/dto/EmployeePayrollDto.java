package com.bl.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class EmployeePayrollDto {

    @Pattern(regexp = "[A-Z]{1}[a-z]{3,20}$",message = "Invalid name")
    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    private String name;

    @NotEmpty(message = "Please Enter salary")
    @NotNull(message = "Please Enter salary ")
    private String salary;

    @NotEmpty(message = "Please Select gender")
    @NotNull(message = "Please Select gender")
    private String gender;

    private String profilePic;

    @NotEmpty(message = "Please Enter department")
    @NotNull(message = "Please Enter department")
    private List<String> department;

    @NotEmpty(message = "Please Enter start date")
    @NotNull(message = "Please Enter start date")
    private String startDate;

    @NotEmpty(message = "Please Enter notes")
    @NotNull(message = "Please Enter notes")
    private String notes;


    public EmployeePayrollDto(String name, String salary, String gender, String profilePic, List<String> department,
                              String startDate, String notes) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.profilePic = profilePic;
        this.department = department;
        this.startDate = startDate;
        this.notes = notes;
    }
}