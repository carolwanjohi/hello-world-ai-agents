package com.example.hello_world.agents;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("greater")
public class GreaterAgentController {
    private final RestTemplate restTemplate;

    public GreaterAgentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/say")
    public String sayHello(@RequestBody String query) {
        String url = "http://localhost:8080/responder/response";

        return restTemplate.postForObject(url, query, String.class);
    }
}
