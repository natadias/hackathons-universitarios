package main.java.collection;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Equipe;

public class EquipeCollection {
    private static EquipeCollection instance;
    private List<Equipe> lista = new ArrayList<>();

    private EquipeCollection() {}

    public static EquipeCollection getInstance() {
        if (instance == null) {
            instance = new EquipeCollection();
        }
        return instance;
    }

    public void adicionar(Equipe equipe) {
        lista.add(equipe);
    }

    public List<Equipe> getLista() {
        return lista;
    }
}

