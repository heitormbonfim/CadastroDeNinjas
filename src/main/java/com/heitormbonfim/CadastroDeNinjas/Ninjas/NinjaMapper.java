package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDto) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setIdade(ninjaDto.getIdade());
        ninjaModel.setNome(ninjaDto.getNome());
        ninjaModel.setRank(ninjaDto.getRank());
        ninjaModel.setMission(ninjaDto.getMission());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMission(ninjaModel.getMission());

        return ninjaDTO;
    }
}
