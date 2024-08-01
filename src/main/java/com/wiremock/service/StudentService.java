package com.wiremock.service;

import com.wiremock.client.StudentClient;
import com.wiremock.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentClient studentClient;

    public StudentDTO getStudent(Long studentId) {
        System.out.println("Invoke method");
        StudentDTO student = studentClient.getStudent(studentId);
        return student;
    }
}
