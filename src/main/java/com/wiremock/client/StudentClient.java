package com.wiremock.client;

import com.wiremock.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-backend-client", url = "http://localhost:1051")
public interface StudentClient {

    @GetMapping("/api/v1/student/{studentId}")
    StudentDTO getStudent(@PathVariable Long studentId);
}
