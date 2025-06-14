package main.java.collection;

import java.util.ArrayList;
import java.util.List;
import main.java.model.Projeto;

public class ProjetoCollection {
    private static ProjetoCollection instance;
    private List<Projeto> lista = new ArrayList<>();

    private ProjetoCollection() {}

    public static ProjetoCollection getInstance() {
        if (instance == null) {
            instance = new ProjetoCollection();
        }
        return instance;
    }

    public void adicionar(Projeto projeto) {
        lista.add(projeto);
    }

    public List<Projeto> getLista() {
        return lista;
    }
}

