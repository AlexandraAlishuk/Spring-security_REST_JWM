package ru.spring.springboot.springsecurity_rest_jwm.exeptions;

import lombok.Data;

import java.util.Date;

@Data
public class AppError {
    private int status;
    private String massage;
    private Date timestamp;

    public AppError(int status, String massage) {
        this.status = status;
        this.massage = massage;
        this.timestamp = new Date();
    }
}
