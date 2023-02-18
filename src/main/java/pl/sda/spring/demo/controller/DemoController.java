package pl.sda.spring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String getHello() {
        log.info("To jest log informacyjny");
        return "Hello world!";
    }
}
