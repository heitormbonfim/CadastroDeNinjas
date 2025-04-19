package com.heitormbonfim.CadastroDeNinjas.Missions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}")
    @Operation(summary = "Update mission", description = "Update the mission saved in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "mission updated successfully"),
            @ApiResponse(responseCode="400", description = "missing attributes")
    })
    public ResponseEntity<?> updateMission(
            @Parameter(description = "User sends the id in the request")
            @PathVariable Long id,
            @Parameter(description = "User sends the data in the request body")
            @RequestBody MissionDTO missionDTO
    ) {
        MissionDTO missionExists = missionService.findMissionById(id);

        if (missionExists != null) {
            MissionDTO mission = missionService.updateMission(id, missionDTO);
            return ResponseEntity.ok(mission);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission not found");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete mission", description = "removes the mission from the database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description="Mission delete"),
            @ApiResponse(responseCode = "400", description = "Mission not found")
    })
    public ResponseEntity<?> deleteMission(
            @Parameter(description="User sends the id of the mission to delete")
            @PathVariable Long id
    ) {
        MissionDTO missionExists = missionService.findMissionById(id);
        if (missionExists != null) {
            missionService.deleteMissionById(id);
            return ResponseEntity.ok("Mission deleted");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mission not found");
    }
}
