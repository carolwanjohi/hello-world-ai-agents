package com.example.hello_world.agents;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("escalation")
public class EscalationAgentController {
    @PostMapping("/escalate")
    public String escalate(@RequestBody String question) {
        return "Escalation Agent: " + question + "\nThis has been escalated to a human agent.";
    }
}
