package main.java.model;

import java.util.HashMap;
import java.util.Map;

import main.java.interfaces.Avaliavel;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados = new HashMap<>();

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
    }

    public void adicionarJurado(Jurado jurado, int nota) {
        jurados.put(jurado, nota);
    }

    @Override
    public void calcularNotaFinal() {
        int soma = jurados.values().stream().mapToInt(Integer::intValue).sum();
        int notaFinal = soma / jurados.size();
        projetoAvaliado.setNotaFinal(notaFinal);
    }

    public Projeto getProjetoAvaliado() {
        return projetoAvaliado;
    }

    public Map<Jurado, Integer> getJurados() {
        return jurados;
    }
}

