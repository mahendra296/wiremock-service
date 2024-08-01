package com.wiremock.integration;

import com.wiremock.interfaces.RequestStub;
import com.wiremock.server.MockStudentServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EndToEndITTest {

    public final MockStudentServer studentServer = new MockStudentServer(1051);

    @BeforeEach
    void beforeEach() {
        studentServer.start();
    }

    @AfterEach
    void afterEach() {
        studentServer.stop();
    }

    protected void withRequestStubs(RequestStub stub) {
        stub.configure();
        // stub.verify();
    }
}

