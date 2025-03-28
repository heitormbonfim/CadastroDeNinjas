package com.heitormbonfim.CadastroDeNinjas.Missoes;

import com.heitormbonfim.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_missions")
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

    public MissionModel(){}

    public MissionModel(Long id, String title, ArrayList<String> objectives, Boolean isComplete) {
        this.name = title;
        this.objectives = objectives;
        this.isComplete = isComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getObjectives() {
        return objectives;
    }

    public void setObjectives(ArrayList<String> objectives) {
        this.objectives = objectives;
    }

    public void setAddObjective(String objective) {
        this.objectives.add(objective);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
