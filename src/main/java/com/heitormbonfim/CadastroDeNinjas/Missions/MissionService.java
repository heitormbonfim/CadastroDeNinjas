package com.heitormbonfim.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public List<MissionDTO> listAllMissions() {
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream().map(missionMapper::map).collect(Collectors.toList());
    }

    public MissionDTO findMissionById(Long id) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        return missionById.map(missionMapper::map).orElse(null);
    }

    public MissionDTO createMission(MissionDTO missionDTO){
        MissionModel mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);
        return missionMapper.map(mission);
    }

    public MissionDTO updateMission(Long id, MissionDTO missionDTO) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        if (missionById.isPresent()) {
            MissionModel missionUpdated = missionMapper.map(missionDTO);
            missionUpdated.setId(id);
            MissionModel missionSaved = missionRepository.save(missionUpdated);
            return missionMapper.map(missionSaved);
        }
        return null;
    }

    public void deleteMissionById(Long id) {
        missionRepository.deleteById(id);
    }
}
