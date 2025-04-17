package com.heitormbonfim.CadastroDeNinjas.Missions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/test")
    public String Welcome() {
        return "Mission router is working";
    }

    @PostMapping("/add")
    @Operation(summary = "Add new mission", description = "this route creates a new mission and saves it in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Mission created successfully"),
            @ApiResponse(responseCode = "400", description = "Missing attributes")
    })
    public ResponseEntity<?> createMission(@RequestBody MissionDTO missionDTO) {
        MissionDTO newMission = missionService.createMission(missionDTO);
        return ResponseEntity.status(201).body(newMission);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMissions() {
        List<MissionDTO> missions = missionService.listAllMissions();
        return ResponseEntity.ok(missions);
    }
}
