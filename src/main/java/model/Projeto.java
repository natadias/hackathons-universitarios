package main.java.model;

public class Projeto {
    private String titulo;
    private Profissional orientador;
    private Equipe equipe;
    private int notaFinal;

    public Projeto(String titulo, Profissional orientador, Equipe equipe) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = 0;
    }

    public void setNotaFinal(int nota) {
        this.notaFinal = nota;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public String getTitulo() {
        return titulo;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Profissional getOrientador() {
        return orientador;
    }
}
