package com.heitormbonfim.CadastroDeNinjas.Missions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionsRepository extends JpaRepository<MissionModel, Long> {
    
}
