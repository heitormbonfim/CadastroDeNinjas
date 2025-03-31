package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    // ORM que vai scanear a classe e criar uma tabela no banco de dados com base no
    // no Model e o tipo do id do model (NinjaModel, Long)
    // Ele sempre vai atualizar caso a classe mude, adaptando a estrutura da tabela no DB
}
