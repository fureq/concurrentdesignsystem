package com.concurrentdesignsystem.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/elo")
    public String elo() {
        return "Elo";
    }
}
