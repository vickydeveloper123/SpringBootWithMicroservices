package com.restapi.RestfullAPIDB.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDetails {

    public LocalDateTime TimeStamp;
    private String message;
    private String path;
    private String errorCode;

    public ErrorDetails(LocalDateTime TimeStamp, String message, String description, String userNotFound) {
        this.TimeStamp=TimeStamp;
        this.message=message;
        this.path=description;
        this.errorCode=userNotFound;
    }
}
