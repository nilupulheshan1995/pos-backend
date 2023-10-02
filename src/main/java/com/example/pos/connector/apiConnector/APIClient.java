package com.example.pos.connector.apiConnector;

public interface APIClient {
    <T> T postForObject(final String uri, Object request, Class<T> responseType);
}
