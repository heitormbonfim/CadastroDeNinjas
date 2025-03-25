package com.heitormbonfim.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

  @GetMapping("/welcome")
  public String Welcome() {
    return "Welcome to my first springboot API";
  }

}
