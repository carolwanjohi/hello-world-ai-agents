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
        Boolean isInternalKnowledge = isInternalKnowledge(question);

        if (isInternalKnowledge) {
            String answer =  getInternalKnowledge(question);
            assert answer != null;
            if (answer.toLowerCase().contains("sorry")) {
                return getExternalKnowledge(question);
            }
            return "Enquiry Agent: " + question + " \nKnowledge Based Response: " + answer;
        } else {
            return getExternalKnowledge(question);
        }
    }

    private Boolean isInternalKnowledge(String query) {
        return query.toLowerCase().contains("price") ||
               query.toLowerCase().contains("return") ||
               query.toLowerCase().contains("location") ||
               query.toLowerCase().contains("contact");
    }

    private String getInternalKnowledge(String query) {
        String url = "http://localhost:8080/knowledge/internal";
        return restTemplate.postForObject(url, query, String.class);
    }

    private String getExternalKnowledge(String query) {
        String url = "http://localhost:8080/escalation/escalate";
        return restTemplate.postForObject(url, query, String.class);
    }
}
