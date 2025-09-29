package ru.aksh.qraccess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class QrController {

    @GetMapping("/string")
    public String getString() {
        return "QrController";
    }
}
