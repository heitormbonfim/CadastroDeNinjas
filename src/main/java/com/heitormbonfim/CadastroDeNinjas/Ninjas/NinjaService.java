package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Precisa adicionar para identificar como camada de serviço
public class NinjaService {
    // @Autowired // remove a necessidade de usar construtores
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
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
    public NinjaModel createNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
}
