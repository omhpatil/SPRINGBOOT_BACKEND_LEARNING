package com.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 20, message = "Number of characters from name will be min 2 and max 20")
    private String name;

    @Email(message = "Email should be valid email")
    private String email;

    @Max(value = 100, message = "Age cannot be greater than 100")
    @Min(value = 18, message = "Age cannot be greater than 18")
    private Integer age;

    private LocalDate dob;

    @NotBlank(message = "Role cannot be blank")
    @Pattern(regexp = "^(ADMIN|ROLE)$", message = "Role of employee either ADMIN or USER")
    private String role;

    @JsonProperty("isActive")
    private Boolean isActive;

}
