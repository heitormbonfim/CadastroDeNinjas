package com.heitormbonfim.CadastroDeNinjas.Missions;

import com.heitormbonfim.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {
    private Long id;
    private String name;
    private List<String> objectives;
    private String level;
    private Boolean isComplete = false;
    private List<NinjaModel> ninjas;
}
