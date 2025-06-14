package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Estudante> membros = new ArrayList<>();

    public Equipe(String nome) {
        this.nome = nome;
    }   

    public void adicionarMembro(Estudante estudante) {
        membros.add(estudante);
    }


    public String getNome() {
        return nome;
    }

    public List<Estudante> getMembros() {
        return membros;
    }
}
