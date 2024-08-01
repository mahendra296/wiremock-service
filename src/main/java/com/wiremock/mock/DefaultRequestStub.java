package com.wiremock.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.CountMatchingStrategy;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import com.wiremock.interfaces.RequestStub;

class DefaultRequestStub implements RequestStub {
    private final WireMockServer wireMockServer;
    private final MappingBuilder mappingBuilder;
    private final CountMatchingStrategy countMatchingStrategy;

    public DefaultRequestStub(WireMockServer wireMockServer, MappingBuilder mappingBuilder) {
        this(wireMockServer, mappingBuilder, WireMock.moreThanOrExactly(1));
    }

    DefaultRequestStub(WireMockServer wireMockServer, MappingBuilder mappingBuilder, CountMatchingStrategy countMatchingStrategy) {
        this.wireMockServer = wireMockServer;
        this.mappingBuilder = mappingBuilder;
        this.countMatchingStrategy = countMatchingStrategy;
    }

    @Override
    public void configure() {
        this.wireMockServer.stubFor(this.mappingBuilder);
    }

    @Override
    public void verify() {
        this.wireMockServer.verify(
                this.countMatchingStrategy,
                RequestPatternBuilder.like(this.mappingBuilder.build().getRequest())
        );
    }

    @Override
    public RequestStub withCountMatchingStrategy(CountMatchingStrategy countMatchingStrategy) {
        return new DefaultRequestStub(this.wireMockServer, this.mappingBuilder, countMatchingStrategy);
    }

    @Override
    public RequestStub withAnyTraceId() {
        return new DefaultRequestStub(
                this.wireMockServer,
                this.mappingBuilder.withHeader("X-B3-TraceId", WireMock.matching("[a-z0-9]{16}"))
        );
    }
}

