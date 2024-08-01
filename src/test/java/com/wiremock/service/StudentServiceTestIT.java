package com.wiremock.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wiremock.dto.StudentDTO;
import com.wiremock.integration.EndToEndITTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class StudentServiceTestIT extends EndToEndITTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getStudent() throws JsonProcessingException {
        withRequestStubs(
        studentServer.respondToStudent(StudentDTO.builder()
                .age(25)
                .firstName("firstName")
                .lastName("lastName")
                .fullName("fullName")
                .build())
        );

        studentService.getStudent(1L);
    }
}