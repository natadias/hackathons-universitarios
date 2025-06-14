package main.java.main;

import java.time.LocalDateTime;

import main.java.collection.ApresentacaoCollection;
import main.java.collection.EquipeCollection;
import main.java.collection.ProjetoCollection;
import main.java.model.Apresentacao;
import main.java.model.Banca;
import main.java.model.Empresa;
import main.java.model.Equipe;
import main.java.model.Estudante;
import main.java.model.Jurado;
import main.java.model.Profissional;
import main.java.model.Projeto;
import main.java.model.Sala;
import main.java.model.Universidade;

public class Main {
    public static void main(String[] args) {

        Universidade uni = new Universidade("Universidade Federal");
        Empresa emp = new Empresa("Tech Solutions");

        Equipe equipe1 = new Equipe("Equipe Alpha");
        Equipe equipe2 = new Equipe("Equipe Beta");

        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("AlunoA" + i, uni));
            equipe2.adicionarMembro(new Estudante("AlunoB" + i, uni));
        }

        EquipeCollection.getInstance().adicionar(equipe1);
        EquipeCollection.getInstance().adicionar(equipe2);

        Profissional orientador1 = new Profissional("Dr. João", uni);
        Profissional orientador2 = new Profissional("Dra. Maria", uni);

        Projeto projeto1 = new Projeto("Projeto Smart City", orientador1, equipe1);
        Projeto projeto2 = new Projeto("Projeto EcoTech", orientador2, equipe2);

        ProjetoCollection.getInstance().adicionar(projeto1);
        ProjetoCollection.getInstance().adicionar(projeto2);

        Banca banca1 = new Banca(projeto1);
        Banca banca2 = new Banca(projeto2);

        for (int i = 1; i <= 4; i++) {
            banca1.adicionarJurado(new Jurado("JuradoA" + i, emp), 7 + i);
            banca2.adicionarJurado(new Jurado("JuradoB" + i, emp), 5 + i);
        }

        Sala sala = new Sala("Sala 101");

        Apresentacao ap1 = new Apresentacao(projeto1, banca1, sala, LocalDateTime.now());
        Apresentacao ap2 = new Apresentacao(projeto2, banca2, sala, LocalDateTime.now());

        ApresentacaoCollection.getInstance().adicionar(ap1);
        ApresentacaoCollection.getInstance().adicionar(ap2);

        ap1.avaliar();
        ap2.avaliar();

        System.out.println("\n=======================");
        System.out.println(" DETALHES DOS PROJETOS");
        System.out.println("=======================\n");

        for (Projeto projeto : ProjetoCollection.getInstance().getLista()) {
            System.out.println(" Projeto: " + projeto.getTitulo());
            System.out.println("    Orientador: " + projeto.getOrientador().getNome());

            // Equipe
            System.out.println("    Equipe: " + projeto.getEquipe().getNome());
            System.out.println("     Membros:");
            for (Estudante estudante : projeto.getEquipe().getMembros()) {
                System.out.println("      - " + estudante.getNome());
            }

            Banca bancaAssociada = null;
            for (Apresentacao ap : ApresentacaoCollection.getInstance().getLista()) {
                if (ap.getProjeto().equals(projeto)) {
                    bancaAssociada = (Banca) ap.getBanca();
                    break;
                }
            }

            if (bancaAssociada != null) {
                System.out.println("    Banca Avaliadora:");
                bancaAssociada.getJurados().forEach((jurado, nota) -> {
                    System.out.println("      - Jurado: " + jurado.getNome() + " -> Nota: " + nota);
                });
            }

            System.out.println("    Nota Final: " + projeto.getNotaFinal());
            System.out.println("-----------------------\n");
        }

        System.out.println(" Projetos Aprovados (nota >= 7):");
        ProjetoCollection.getInstance().getLista().stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .forEach(p -> System.out.println(p.getTitulo() + " - Nota: " + p.getNotaFinal()));
    }
}
