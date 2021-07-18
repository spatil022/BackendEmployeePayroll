package com.bl.employeepayrollapp.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String message;
    private String status;
    private Object data;

    public ResponseDto(String message, String status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}