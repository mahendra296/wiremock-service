package com.wiremock.interfaces;

import com.github.tomakehurst.wiremock.client.MappingBuilder;

public interface MockServer {
    void start();
    void stop();

    /**
     * Creates a {@link RequestStub} which will be configured with the provided
     * {@link MappingBuilder} and verified against the request pattern
     * from the very same {@link MappingBuilder}.
     */
    RequestStub requestStub(MappingBuilder mappingBuilder);
}
