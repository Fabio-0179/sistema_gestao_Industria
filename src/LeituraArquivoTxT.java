import java.io.*;
import java.util.*;

class Aluno {
    String nome;
    int nota;

    Aluno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    boolean estaAprovado() {
        return nota >= 80;
    }
}

public class LeituraArquivoTxT {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();

        // Leitura do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0].trim();
                int nota = Integer.parseInt(partes[1].trim());
                alunos.add(new Aluno(nome, nota));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Cálculo da média geral
        double somaNotas = 0;
        int maiorNota = Integer.MIN_VALUE;
        Aluno alunoComMaiorNota = null;

        for (Aluno aluno : alunos) {
            somaNotas += aluno.nota;
            if (aluno.nota > maiorNota) {
                maiorNota = aluno.nota;
                alunoComMaiorNota = aluno;
            }
        }

        double mediaGeral = somaNotas / alunos.size();

        // Exibição dos resultados
        System.out.printf("%-10s %-5s %-12s %-18s\n", "Nome", "Nota", "Status", "Acima da Média");
        System.out.println("------------------------------------------------------");

        for (Aluno aluno : alunos) {
            String status = aluno.estaAprovado() ? "Aprovado" : "Reprovado";
            String acimaMedia = aluno.nota > mediaGeral ? "Sim" : "Não";
            System.out.printf("%-10s %-5d %-12s %-18s\n", aluno.nome, aluno.nota, status, acimaMedia);
        }

        System.out.println("\nAluno com a maior nota: " + alunoComMaiorNota.nome + " (" + alunoComMaiorNota.nota + ")");
        System.out.printf("Média geral das notas: %.2f\n", mediaGeral);
    }
}