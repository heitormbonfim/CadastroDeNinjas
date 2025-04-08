package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Precisa adicionar para identificar como camada de serviço
public class NinjaService {
    // @Autowired // remove a necessidade de usar construtores
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List all ninjas
    public List<NinjaModel> listAllNinjas() {
        return ninjaRepository.findAll();
    }

    // Get ninjas by id
    public NinjaModel getNinjaById(Long id) {
        // in case the user is not found
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.orElse(null); // return null in case the user is not found
    }

    // Create ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Update ninja
    public NinjaModel updateNinja(Long id, NinjaModel ninjaUpdated) {
        if (ninjaRepository.existsById(id)) {
            ninjaUpdated.setId(id);
            return ninjaRepository.save(ninjaUpdated);
        }
        return null;
    }

    // Delete ninja
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }
}
