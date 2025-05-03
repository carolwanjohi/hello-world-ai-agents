package com.example.hello_world.agents;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("enquiry")
public class EnquiryAgentController {
    private final RestTemplate restTemplate;

    @PostMapping("/ask")
    public String askQuestion(@RequestBody String question) {
        if (isInternalKnowledge(question)) {
            return getInternalKnowledge(question);
        }
        return getExternalKnowledge(question);
    }

    private Boolean isInternalKnowledge(String query) {
        return query.toLowerCase().contains("price") ||
               query.toLowerCase().contains("return") ||
               query.toLowerCase().contains("location") ||
               query.toLowerCase().contains("contact");
    }

    private String getInternalKnowledge(String query) {
        String url = "http://localhost:8080/knowledge/internal";
        String answer = restTemplate.postForObject(url, query, String.class);
        assert answer != null;
        if (answer.toLowerCase().contains("sorry")) {
            return getExternalKnowledge(query);
        }
        return "Enquiry Agent: " + query + " \nKnowledge Based Response: " + answer;
    }

    private String getExternalKnowledge(String query) {
        String url = "http://localhost:8080/escalation/escalate";
        return restTemplate.postForObject(url, query, String.class);
    }
}
