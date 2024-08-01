package com.wiremock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String fullName;
    private String totalSubject;
}
