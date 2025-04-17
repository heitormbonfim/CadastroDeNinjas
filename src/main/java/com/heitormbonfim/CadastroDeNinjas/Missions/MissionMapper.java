package com.heitormbonfim.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public MissionModel map(MissionDTO missionDto) {
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDto.getId());
        missionModel.setName(missionDto.getName());
        missionModel.setLevel(missionDto.getLevel());
        missionModel.setIsComplete(missionDto.getIsComplete());
        missionModel.setObjectives(missionDto.getObjectives());
        missionModel.setNinjas(missionDto.getNinjas());

        return missionModel;
    }

    public MissionDTO map(MissionModel missionModel) {
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setIsComplete(missionModel.getIsComplete());
        missionDTO.setLevel(missionModel.getLevel());
        missionDTO.setObjectives(missionModel.getObjectives());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }
}
