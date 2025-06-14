package main.java.collection;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Apresentacao;

public class ApresentacaoCollection {
    private static ApresentacaoCollection instance;
    private List<Apresentacao> lista = new ArrayList<>();

    private ApresentacaoCollection() {}

    public static ApresentacaoCollection getInstance() {
        if (instance == null) {
            instance = new ApresentacaoCollection();
        }
        return instance;
    }

    public void adicionar(Apresentacao apresentacao) {
        lista.add(apresentacao);
    }

    public List<Apresentacao> getLista() {
        return lista;
    }
}

