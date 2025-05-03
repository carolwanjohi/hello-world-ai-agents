package com.example.hello_world.agents;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("responder")
public class ResponderAgentController {

    @PostMapping("/response")
    public String response(@RequestBody String message) {
        if ("Hello".equalsIgnoreCase(message)) {
            return "Hello, how can I help you?";
        } else if ("Goodbye".equalsIgnoreCase(message)) {
            return "Goodbye, have a great day!";
        } else if ("Thank you".equalsIgnoreCase(message)) {
            return "You're welcome!";
        } else {
            return "I don't understand that message.";
        }
    }
}
