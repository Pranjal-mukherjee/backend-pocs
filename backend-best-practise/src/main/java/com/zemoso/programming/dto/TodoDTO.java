package com.zemoso.programming.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO implements Serializable {
    private int id;
    @NotEmpty(message = "Title Enter")
    @JsonProperty("user_title")

    private String title;
    @NotEmpty(message = "desc enter")
    @Size(min = 3, message = "Size 3 big", max = 10)
    @JsonProperty("user_desc")
    private String description;
    @JsonIgnore
    private boolean completionStatus;
}
