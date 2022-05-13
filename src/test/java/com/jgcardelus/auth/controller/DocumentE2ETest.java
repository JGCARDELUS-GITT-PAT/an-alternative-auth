package com.jgcardelus.auth.controller;

import com.jgcardelus.auth.model.DocumentModel;
import com.jgcardelus.auth.repository.DocumentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocumentE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private DocumentRepository repository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void documentGetTest() {
        Iterable<DocumentModel> documents = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/documents";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<DocumentModel>> result = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<DocumentModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(documents);
    }
}
