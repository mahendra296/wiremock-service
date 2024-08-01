package com.wiremock.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.wiremock.dto.StudentDTO;
import com.wiremock.interfaces.RequestStub;
import com.wiremock.mock.WireMockMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class MockStudentServer extends WireMockMockServer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public MockStudentServer(int portNumber) {
        super(portNumber);
    }

    public MockStudentServer() {
    }

    public RequestStub respondToStudent(StudentDTO response) throws JsonProcessingException {
        return requestStub(
                WireMock.get(urlEqualTo("/api/v1/student/1"))
                        .willReturn(WireMock.okJson(objectMapper.writeValueAsString(response)))
        );
    }
}