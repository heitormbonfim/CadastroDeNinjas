package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
  private final NinjaService ninjaService;

  public NinjaController(NinjaService ninjaService) {
    this.ninjaService = ninjaService;
  }

  @GetMapping("/welcome")
  @Operation(summary = "Welcome Message", description = "This route returns a welcome message for those who access it")
  public String welcome() {
    return "Welcome to my first springboot API";
  }

  // ADD NINJAS
  @PostMapping("/add")
  @Operation(summary = "Add a new User", description = "This route creates a new ninja and saves it in the database")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Ninja created successfully"),
          @ApiResponse(responseCode = "400", description = "Missing attributes")
  })
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
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Ninja updated successfully"),
          @ApiResponse(responseCode = "400", description = "Missing attributes"),
  })
  public ResponseEntity<?> updateNinja(
          @Parameter(description = "User sends the id in the request path")
          @PathVariable Long id,
          @Parameter(description = "User sends the ninja data to be sent in the request body")
          @RequestBody NinjaDTO ninjaUpdated) {
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
