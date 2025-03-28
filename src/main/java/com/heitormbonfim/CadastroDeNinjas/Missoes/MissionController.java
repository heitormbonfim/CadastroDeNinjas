package com.heitormbonfim.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissionController {

    @GetMapping("/hello-missions")
    public String hello() {
        return "Hello from mission controller";
    }
}
