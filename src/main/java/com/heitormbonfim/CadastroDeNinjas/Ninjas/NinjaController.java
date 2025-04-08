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
  public NinjaModel createNinja(@RequestBody NinjaModel ninja) {

    return ninjaService.createNinja(ninja);
  }
  // GET ALL NINJAS
  @GetMapping("/all")
  public List<NinjaModel> getAllNinjas() {
    return ninjaService.listAllNinjas();
  }
  // SEARCH NINJA BY ID
  @GetMapping("/{id}") // {} creates a poth variable called id
  public NinjaModel getNinjaById(@PathVariable Long id) { // @PathVariable consumes the data that was created at {}
    return ninjaService.getNinjaById(id);
  }
  // UPDATE NINJA DATA
  @PutMapping("/{id}")
  public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaUpdated) {
    return ninjaService.updateNinja(id, ninjaUpdated);
  }
  // DELETE NINJA
  @DeleteMapping("/{id}")
  public void deleteNinja(@PathVariable Long id) {
    ninjaService.deleteNinjaById(id);
  }
}
