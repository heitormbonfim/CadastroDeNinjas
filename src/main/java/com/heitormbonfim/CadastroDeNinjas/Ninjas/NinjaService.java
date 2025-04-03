package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
