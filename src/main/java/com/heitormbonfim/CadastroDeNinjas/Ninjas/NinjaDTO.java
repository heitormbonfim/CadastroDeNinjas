package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import com.heitormbonfim.CadastroDeNinjas.Missions.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private MissionModel mission ;
    private String rank;
}
