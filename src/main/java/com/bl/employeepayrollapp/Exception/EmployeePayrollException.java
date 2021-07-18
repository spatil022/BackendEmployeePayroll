package com.bl.employeepayrollapp.Exception;

public class EmployeePayrollException extends RuntimeException{

    public ExceptionTypes exceptionTypes;

    public EmployeePayrollException(ExceptionTypes exceptionTypes){
        this.exceptionTypes=exceptionTypes;
    }

    public enum ExceptionTypes {
        EMPLOYEE_ALREADY_PRESENT("employee Already present"),
        EMPLOYEE_NOT_FOUND("employee not found"),
        EMPLOYEE_NOT_PRESENT("employee is not present in database");
        public String errorMsg;
        ExceptionTypes(String errorMsg){
            this.errorMsg =errorMsg;
        }
    }
}