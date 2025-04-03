package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
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
