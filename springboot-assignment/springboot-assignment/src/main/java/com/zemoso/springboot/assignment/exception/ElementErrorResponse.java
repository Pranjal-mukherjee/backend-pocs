package com.zemoso.springboot.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
