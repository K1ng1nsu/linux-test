package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    private final GreetingRepository greetingRepository;

    public HelloController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/")
    public String hello(HttpServletRequest request) {

        return "Hello World" + request.getRemoteAddr();
    }

    @GetMapping("/greeting")
    public String greet(@RequestParam(defaultValue = "kr") String lang) {
        Optional<Greeting> byLangCode = greetingRepository.findByLangCode(lang);
        if (byLangCode.isEmpty()) {
            return "CAN NOT FOUND LANG CODE";
        }
        return byLangCode.get().getMessage();

    }
}
