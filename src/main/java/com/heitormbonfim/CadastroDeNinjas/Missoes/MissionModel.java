package com.heitormbonfim.CadastroDeNinjas.Missoes;

import com.heitormbonfim.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_missions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> objectives = new ArrayList<>();
    private String level;
    private Boolean isComplete = false;

    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

    public void setAddObjective(String objective) {
        this.objectives.add(objective);
    }
}
