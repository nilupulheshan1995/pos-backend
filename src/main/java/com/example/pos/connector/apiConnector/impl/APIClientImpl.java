package com.example.pos.connector.apiConnector.impl;

import com.example.pos.connector.apiConnector.APIClient;

public class APIClientImpl implements APIClient {

    @Override
    public <T> T postForObject(String uri, Object request, Class<T> responseType) {
        // normally using rest template
        return null;
    }
}
