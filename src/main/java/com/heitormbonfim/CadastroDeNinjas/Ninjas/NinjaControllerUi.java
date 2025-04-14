package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // ninjas/ui/all
    @GetMapping("/all")
    public String getAllNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listAllNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjas";
    }
}
