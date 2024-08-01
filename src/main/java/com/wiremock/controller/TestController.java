package com.wiremock.controller;

import com.wiremock.dto.StudentDTO;
import com.wiremock.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    private final StudentService studentService;

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok().body("Hello");
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok().body(studentService.getStudent(studentId));
    }
}
