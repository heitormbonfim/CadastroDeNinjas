package com.heitormbonfim.CadastroDeNinjas.Ninjas;

import com.heitormbonfim.CadastroDeNinjas.Missoes.MissionModel;
import jakarta.persistence.*;

import java.util.List;

// Padrão Prefixo é a entidade e o sufixo é o Padrão: Nijna + Model
// Anotations pega tudo que está abaixo e para até onde tem ; ou quando uma chave se fecha {}
@Entity // transforma uma classe em uma entidade do banco de dados
@Table(name="tb_cadastro") // é uma convensão esse_formato_de_nome_de_table com tb_no_inicio
public class NinjaModel {
    @Id // para criar o id automaticamente (sem setter ou getter)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // forma que vai ser gerado
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // Um ninja tem apenas uma única missão
    @ManyToOne()
    @JoinColumn(name = "missions_id") // Foreign Key
    private List<MissionModel> missions;


    public NinjaModel() {}

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
