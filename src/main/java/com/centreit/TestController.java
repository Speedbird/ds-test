package com.centreit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/")
@Transactional
public class TestController {


    @GetMapping
    public String getHello() {
        return "application";

    }

}
