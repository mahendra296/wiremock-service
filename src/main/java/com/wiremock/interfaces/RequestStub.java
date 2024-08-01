package com.wiremock.interfaces;

import com.github.tomakehurst.wiremock.client.CountMatchingStrategy;

public interface RequestStub {
    void configure();
    void verify();

    /**
     * Create a copy of this request stub with a given request count matching strategy.
     */
    RequestStub withCountMatchingStrategy(CountMatchingStrategy countMatchingStrategy);

    /**
     * Create a copy of this request stub which accepts any trace ID header.
     */
    RequestStub withAnyTraceId();
}
