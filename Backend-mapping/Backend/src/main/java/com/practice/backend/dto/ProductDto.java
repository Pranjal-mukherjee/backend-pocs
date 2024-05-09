package com.practice.backend.dto;

import com.practice.backend.Enum.Roles;
import com.practice.backend.Enum.Status;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String productName;
    private String price;
    private Status status;
    private int user_id;
}
