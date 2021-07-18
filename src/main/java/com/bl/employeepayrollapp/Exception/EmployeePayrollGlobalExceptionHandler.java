package com.bl.employeepayrollapp.Exception;

import com.bl.employeepayrollapp.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class EmployeePayrollGlobalExceptionHandler {

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDto> handlePayrollException(EmployeePayrollException employeePayrollException){
        log.error("Exception Occurred : " + employeePayrollException.exceptionTypes.errorMsg);

        return new ResponseEntity<ResponseDto>(new ResponseDto(employeePayrollException.exceptionTypes.errorMsg,null,null),
                HttpStatus.BAD_REQUEST);
    }
}