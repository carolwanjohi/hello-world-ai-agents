package com.example.hello_world.agents;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("knowledge")
public class KnowledgeAgentController {

    @PostMapping("/internal")
    public String internalKnowledge(@RequestBody String query) {
        if (query.toLowerCase().contains("price")) {
            return "The price is $100.";
        } else if (query.toLowerCase().contains("return")) {
            return "The return policy is 30 days.";
        } else if (query.toLowerCase().contains("location")) {
            return "The location is 123 Main St.";
        } else if (query.toLowerCase().contains("contact")) {
            return "You can contact me via email at test@test.com";
        } else {
            return "Sorry, I don't have that information.";
        }
    }
}
