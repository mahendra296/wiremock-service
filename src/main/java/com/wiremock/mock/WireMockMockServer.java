package com.wiremock.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.wiremock.interfaces.MockServer;
import com.wiremock.interfaces.RequestStub;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.moreThanOrExactly;

@Component
public class WireMockMockServer implements MockServer {
    private final WireMockServer wireMockServer;

    public WireMockMockServer(int portNumber) {
        this.wireMockServer = new WireMockServer(portNumber);
        this.wireMockServer.stubFor(WireMock.get(WireMock.anyUrl()).willReturn(WireMock.notFound()));
    }

    public WireMockMockServer(){
        this.wireMockServer = new WireMockServer(1052);
    }

    @Override
    public void start() {
        this.wireMockServer.start();
    }

    @Override
    public void stop() {
        this.wireMockServer.stop();
    }

    @Override
    public RequestStub requestStub(MappingBuilder mappingBuilder) {
        return new DefaultRequestStub(
                this.wireMockServer,
                mappingBuilder,
                moreThanOrExactly(1)
        );
    }
}

