package com.heitormbonfim.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
public class MissionController {

    @GetMapping("/test")
    public String Welcome() {
        return "Mission router is working";
    }

}
