package menu;

import dao.ProducaoDAO;
import dao.ProdutoDAO;
import model.Producao;
import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProducaoMenu {
    private static ProdutoDAO dao = new ProdutoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU SETOR ---");
            System.out.println("[1] Listar setores");
            System.out.println("[2] Buscar setor por ID");
            System.out.println("[3] Cadastrar setor");
            System.out.println("[4] Atualizar setor");
            System.out.println("[5] Remover setor");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listarProducoes();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                 //   atualizarProducao);
                    break;
                case 5:
                  //  removerProducao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void listarProducoes() {
        ArrayList<Produto> producoes = dao.listar();
        if (producoes != null && !producoes.isEmpty()) {
            for (Produto producao : producoes) {
                System.out.println(producao);
            }
        } else {
            System.out.println("Nenhum setor encontrado.");
        }
    }

    private static void buscarPorId() {
        System.out.print("Digite o ID do producao: ");
        int id = scanner.nextInt();
        Produto producao = dao.buscarPorId(id);
        if (producao != null) {
            System.out.println(producao);
        } else {
            System.out.println("model.Setor não encontrado.");
        }
    }

    private static void cadastrarProducao() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Responsável: ");
        String responsavel = scanner.nextLine();
        Producao producao = new Producao(null, nome, responsavel);
        if (dao.cadastrar(producao.getProduto())) {
            System.out.println("model.Setor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar setor.");
        }
    }

    private static void atualizarSetor() {
        System.out.print("ID do setor a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        Produto producao = dao.buscarPorId(id);
        if (producao == null) {
            System.out.println("model.Setor não encontrado.");
            return;
        }
        System.out.print("Novo nome do setor: ");
        String nome = scanner.nextLine();
        System.out.print("Novo responsável: ");
        String responsavel = scanner.nextLine();
        producao.setNome(nome);
        producao.setResponsavel(responsavel);
        if (dao.atualizar(producao)) {
            System.out.println("model.Setor atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar setor.");
        }
    }

    private static void removerSetor() {
        System.out.print("ID do setor a remover: ");
        int id = scanner.nextInt();
        if (dao.remover(id)) {
            System.out.println("model.Setor removido com sucesso!");
        } else {
            System.out.println("Erro ao remover setor.");
        }
    }

}
