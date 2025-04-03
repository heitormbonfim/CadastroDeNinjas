package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

  @GetMapping("/welcome")
  public String Welcome() {
    return "Welcome to my first springboot API";
  }

  // ADD NINJAS
  @PostMapping("/add")
  public String createNinja() {
    return "Ninja created";
  }
  // GET ALL NINJAS
  @GetMapping("/all")
  public String getAllNinjas() {
    return "Ninjas";
  }
  // SEARCH NINJA BY ID
  @GetMapping("/ninjaID")
  public String getNinjaById() {
    return "Ninja got by id";
  }
  // UPDATE NINJA DATA
  @PutMapping("/ninjaID")
  public String updateNinja() {
    return "Ninja updated";
  }
  // DELETE NINJA
  @DeleteMapping("/ninjaID")
  public String deleteNinja() {
    return "Ninja deleted";
  }

}
