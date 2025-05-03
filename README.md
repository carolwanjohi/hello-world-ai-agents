# Hello World

A proejct to learn about AI agents and their interactions.

## AI Agents

### GreaterAgent and ResponseAgent

Receives a greeting request and generates a response.
```mermaid
flowchart TD
    A(["User"])
    A --> B[GreaterAgent]
    B --> C[ResponseAgent]
```

### EnquiryAgent, KnowledgeAgent, and EscalationAgent

Receives a request and determines if it is simple or hard.\
When it is simple, it generates a response using the KnowledgeAgent.\
When it is hard, it generates a response using the EscalationAgent.

```mermaid
flowchart TD
    A(["User"])
    A --> B[EnquiryAgent]
    B --> C{"Decision"}
    C --> D[KnowledgeAgent]
    C --> E[EscalationAgent]
```
