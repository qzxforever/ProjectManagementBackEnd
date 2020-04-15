package org.bestsoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping(value = "/healthCheck")
    public String healthCheck() {
        return "Server is Running";
    }
}
