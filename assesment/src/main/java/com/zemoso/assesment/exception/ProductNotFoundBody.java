package com.zemoso.assesment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductNotFoundBody {
    private int status;
    private String message;
    private long timeStamp;
}