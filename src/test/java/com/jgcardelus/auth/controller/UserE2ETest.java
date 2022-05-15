package com.jgcardelus.auth.controller;

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
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.BDDAssertions.then;

import com.jgcardelus.auth.model.UserModel;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void userPostTest() {
        UserModel user = new UserModel();
        user.setUsername("user4");
        user.setEmail("algo");
        user.setPassword("password");

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6cXdlcnR5MTIz");

        HttpEntity<UserModel> entity = new HttpEntity<>(user,headers);

        ResponseEntity<UserModel> result = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            new ParameterizedTypeReference<UserModel>(){}
        );

        user.setPassword(result.getBody().getPassword());

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(user);
    }
}
