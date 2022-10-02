package ru.yandex.practicum.catsgram.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/home")
    public String homePage() {
        log.info("Получен запрос.");
        return "Котограм";
    }
}
