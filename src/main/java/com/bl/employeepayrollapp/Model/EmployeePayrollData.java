package com.bl.employeepayrollapp.Model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class EmployeePayrollData implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID employeeId;

    @Pattern(regexp = "[A-Z]{1}[a-z]{3,20}$",message = "Invalid name")
    @NotEmpty(message = "Invalid name")
    @NotNull(message = "Invalid name")
    private String name;

    @NotEmpty(message = "Please Enter salary")
    @NotNull(message = "Please Enter salary")
    private String salary;

    @NotEmpty(message = "Please Select gender")
    @NotNull(message = "Please Select gender")
    private String gender;

    private String profilePic;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "employeeId"))
    @NotEmpty(message = "Please Enter department")
    @NotNull(message = "Please Enter department")
    private List<String> department;

    @NotNull(message = "Please Enter start date")
    @NotEmpty(message = "Please Enter start date")
    private String startDate;

    @NotNull(message = "Please Enter notes")
    @NotEmpty(message = "Please Enter notes")
    private String notes;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    public EmployeePayrollData(String name, String salary, String gender , String profilePic , List<String> department, String startDate, String notes) {
        this.name=name;
        this.salary=salary;
        this.gender=gender;
        this.profilePic=profilePic;
        this.department=department;
        this.startDate=startDate;
        this.notes=notes;

    }

    public EmployeePayrollData(EmployeePayrollData employee) {
        this.employeeId=employee.getEmployeeId();
        this.name= employee.getName();
        this.salary=employee.getSalary();
        this.gender=employee.getGender();
        this.profilePic=employee.getProfilePic();
        this.department=employee.getDepartment();
        this.startDate=employee.getStartDate();
        this.notes=employee.getNotes();
        this.updatedAt=employee.getUpdatedAt();

    }
}