package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Precisa adicionar para identificar como camada de serviço
public class NinjaService {
    // @Autowired // remove a necessidade de usar construtores
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List all ninjas
    public List<NinjaDTO> listAllNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(ninjaMapper::map).collect(Collectors.toList());
    }

    // Get ninjas by id
    public NinjaDTO getNinjaById(Long id) {
        // in case the user is not found
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null); // return null in case the user is not found
    }

    // Create ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Update ninja
    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
       Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
       if (ninjaById.isPresent()) {
           NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
           ninjaUpdated.setId(id);
           NinjaModel ninjaSaved = ninjaRepository.save(ninjaUpdated);
           return ninjaMapper.map(ninjaSaved);
       }
       return null;
    }

    // Delete ninja
    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }
}
