package com.bl.employeepayrollapp.Controller;

import com.bl.employeepayrollapp.Model.EmployeePayrollData;
import com.bl.employeepayrollapp.Services.IEmployeePayrollServices;
import com.bl.employeepayrollapp.Services.EmployeePayrollServices;
import com.bl.employeepayrollapp.dto.EditPayrollDto;
import com.bl.employeepayrollapp.dto.EmployeePayrollDto;
import com.bl.employeepayrollapp.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.Optional;



@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollServices employeePayrollServices = new EmployeePayrollServices();

    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollData>> getAllUser(){
        System.out.println("InsidegetAllusers");
        return ResponseEntity.status(HttpStatus.OK).body(employeePayrollServices.getAllUser());
    }

    @GetMapping("/getbyId")
    public ResponseEntity<ResponseDto> getUserById(@RequestParam(value = "employeeId") UUID employeeId){

        EmployeePayrollData employeePayrollData = employeePayrollServices.getUserById(employeeId);
        return new ResponseEntity<ResponseDto>(new ResponseDto("employee you are finding are"
                ,"200", employeePayrollData),
                HttpStatus.OK);

    }

    @PostMapping("/Create")
    public ResponseEntity<ResponseDto> CreateUser(@RequestBody @Valid EmployeePayrollDto employee,
                                                  BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                    get(0).getDefaultMessage(),"100",null),
                    HttpStatus.BAD_REQUEST);
        }

        EmployeePayrollData employeePayrollData = employeePayrollServices.CreateUser(employee);

        return new ResponseEntity<ResponseDto>(new ResponseDto("Employee added Successfully",
                "200", employeePayrollData),
                HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateById(@RequestBody @Valid EditPayrollDto user,
                                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                    get(0).getDefaultMessage(),"100",null),
                    HttpStatus.BAD_REQUEST);
        }

        EmployeePayrollData employeePayrollData = employeePayrollServices.updateById(user);
        return new ResponseEntity<ResponseDto>(new ResponseDto("Employee detailes updated successfully for " ,
                "200", employeePayrollData),
                HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable("id") UUID employeeId){
        EmployeePayrollData employeePayrollData = employeePayrollServices.deleteById(employeeId);
        return new ResponseEntity<ResponseDto>(new ResponseDto("Employee deleted successfully",
                "200", employeePayrollData),
                HttpStatus.CREATED);

    }

}