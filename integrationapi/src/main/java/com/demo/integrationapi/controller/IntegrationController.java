package com.demo.integrationapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class IntegrationController {


    @GetMapping("/customer")
    public Map callApiWithSpringSecure() throws IOException {
        URL url = new URL("https://api.razorpay.com/v1/customers?count=1");
        String encoding = Base64.getEncoder().encodeToString(("rzp_test_pCovO5uBVTngQU:RlS3lokJHxdYR8aMq0DFFAUh").getBytes(StandardCharsets.UTF_8));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty  ("Authorization", "Basic " + encoding);
        InputStream inputStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, Map.class);
    }



}
