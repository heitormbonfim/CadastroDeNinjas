package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {

    return ninjaService.createNinja(ninja);
  }
  // GET ALL NINJAS
  @GetMapping("/all")
  public ResponseEntity<List<NinjaDTO>> getAllNinjas() {
    List<NinjaDTO> ninjas = ninjaService.listAllNinjas();
    return ResponseEntity.ok(ninjas);
  }
  // SEARCH NINJA BY ID
  @GetMapping("/{id}") // {} creates a poth variable called id
  // the ? is a generic type since you cannot add T in this case
  public ResponseEntity<?>  getNinjaById(@PathVariable Long id) { // @PathVariable consumes the data that was created at {}
    NinjaDTO ninja = ninjaService.getNinjaById(id);

    if (ninja != null) {
      return ResponseEntity.status(HttpStatus.OK).body(ninja);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja not found");
  }
  // UPDATE NINJA DATA
  @PutMapping("/{id}")
  public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaUpdated) {
    NinjaDTO ninjaExists = ninjaService.getNinjaById(id);

    if (ninjaExists != null) {
      NinjaDTO ninja = ninjaService.updateNinja(id, ninjaUpdated);
      return ResponseEntity.status(HttpStatus.OK).body(ninja);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja not found");

  }
  // DELETE NINJA
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteNinja(@PathVariable Long id) {
    NinjaDTO ninjaExist = ninjaService.getNinjaById(id);

    if (ninjaExist != null) {
      ninjaService.deleteNinjaById(id);
      return ResponseEntity.status(HttpStatus.OK).body("Ninja Deleted");
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja not found");
  }
}
