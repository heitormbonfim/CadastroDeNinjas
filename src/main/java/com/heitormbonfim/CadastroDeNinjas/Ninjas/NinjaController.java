package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
  private NinjaService ninjaService;

  public NinjaController(NinjaService ninjaService) {
    this.ninjaService = ninjaService;
  }

  @GetMapping("/welcome")
  public String welcome() {
    return "Welcome to my first springboot API";
  }

  // ADD NINJAS
  @PostMapping("/add")
  public String createNinja() {
    return "Ninja created";
  }
  // GET ALL NINJAS
  @GetMapping("/all")
  public List<NinjaModel> getAllNinjas() {
    return ninjaService.listAllNinjas();
  }
  // SEARCH NINJA BY ID
  @GetMapping("/id")
  public String getNinjaById() {
    return "Ninja got by id";
  }
  // UPDATE NINJA DATA
  @PutMapping("/id")
  public String updateNinja() {
    return "Ninja updated";
  }
  // DELETE NINJA
  @DeleteMapping("/id")
  public String deleteNinja() {
    return "Ninja deleted";
  }

}
