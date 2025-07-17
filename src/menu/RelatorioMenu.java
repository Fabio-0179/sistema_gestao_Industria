package menu;

import dao.RelatorioDAO;
import model.Relatorio;

import java.util.ArrayList;
import java.util.Scanner;


import dao.RelatorioDAO;
import model.Relatorio;

import java.util.ArrayList;
import java.util.Scanner;

public class RelatorioMenu {

    private static RelatorioDAO relatorioDAO = new RelatorioDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU DE RELATÓRIOS ---");
            System.out.println("[1] Listar funcionários de um setor específico");
            System.out.println("[2] Mostrar produtos produzidos em uma determinada data");
            System.out.println("[3] Contar quantos produtos cada funcionário já produziu (Total)");
            System.out.println("[4] Listar todos os funcionários, seus setores e produtos produzidos");
            System.out.println("[5] Listar produtos produzidos em data específica (detalhes)");
            System.out.println("[0] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Consome a entrada inválida
                opcao = -1; // Define uma opção inválida para continuar o loop
                continue;
            }
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listarFuncionariosPorSetor();
                    break;
                case 2:
                    listarProdutosProduzidosEmData();
                    break;
                case 3:
                    contarProdutosPorFuncionario();
                    break;
                case 4:
                    listarFuncionariosSetoresProdutosProduzidos();
                    break;
                case 5:
                    listarProdutosProduzidosComDetalhes();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void listarFuncionariosPorSetor() {
        System.out.print("Digite o nome do setor: ");
        String nomeSetor = scanner.nextLine();
        ArrayList<Relatorio> relatorios = relatorioDAO.listarFuncionariosPorSetor(nomeSetor);
        if (relatorios != null && !relatorios.isEmpty()) {
            System.out.println("\n--- Funcionários do Setor: " + nomeSetor + " ---");
            for (Relatorio r : relatorios) {
                System.out.println("Nome: " + r.getCampo1() + " " + r.getCampo2());
            }
        } else {
            System.out.println("Nenhum funcionário encontrado para o setor '" + nomeSetor + "' ou ocorreu um erro.");
        }
    }

    private static void listarProdutosProduzidosEmData() {
        System.out.print("Digite a data (YYYY-MM-DD): ");
        String data = scanner.nextLine();
        ArrayList<Relatorio> relatorios = relatorioDAO.listarProdutosProduzidosEmData(data);
        if (relatorios != null && !relatorios.isEmpty()) {
            System.out.println("\n--- Produtos Produzidos em " + data + " ---");
            for (Relatorio r : relatorios) {
                System.out.println("Produto: " + r.getCampo1() + " | Quantidade: " + r.getCampoNumerico());
            }
        } else {
            System.out.println("Nenhum produto encontrado para a data '" + data + "' ou ocorreu um erro.");
        }
    }

    private static void contarProdutosPorFuncionario() {
        System.out.println("\n--- Total de Produtos Produzidos por Funcionário ---");
        ArrayList<Relatorio> relatorios = relatorioDAO.contarProdutosPorFuncionario();
        if (relatorios != null && !relatorios.isEmpty()) {
            for (Relatorio r : relatorios) {
                System.out.println("Funcionário: " + r.getCampo1() + " | Total Produzido: " + r.getCampoNumerico());
            }
        } else {
            System.out.println("Nenhum dado de produção encontrado ou ocorreu um erro.");
        }
    }

    private static void listarFuncionariosSetoresProdutosProduzidos() {
        System.out.println("\n--- Funcionários, Setores e Produtos Produzidos ---");
        ArrayList<Relatorio> relatorios = relatorioDAO.listarFuncionariosSetoresProdutosProduzidos();
        if (relatorios != null && !relatorios.isEmpty()) {
            // Para exibir de forma mais organizada, podemos agrupar por funcionário
            String currentFuncionario = "";
            for (Relatorio r : relatorios) {
                if (!r.getCampo1().equals(currentFuncionario)) {
                    currentFuncionario = r.getCampo1();
                    System.out.println("\nFuncionário: " + r.getCampo1() + " | Setor: " + r.getCampo2());
                    System.out.println("  Produções:");
                }
                // Verifica se há produto produzido para evitar "Nenhum produto" em cada linha de produção
                if (r.getCampoNumerico() != null) {
                    System.out.println("    - Produto: " + r.getCampo3() + " | Quantidade: " + r.getCampoNumerico() + r.getCampo4());
                } else {
                    System.out.println("    - " + r.getCampo3()); // Caso não tenha produção
                }
            }
        } else {
            System.out.println("Nenhum dado encontrado ou ocorreu um erro.");
        }
    }

    private static void listarProdutosProduzidosComDetalhes() {
        System.out.print("Digite a data (YYYY-MM-DD): ");
        String data = scanner.nextLine();
        ArrayList<Relatorio> relatorios = relatorioDAO.listarProdutosProduzidosComDetalhes(data);
        if (relatorios != null && !relatorios.isEmpty()) {
            System.out.println("\n--- Produtos Produzidos em " + data + " (Detalhes) ---");
            for (Relatorio r : relatorios) {
                System.out.println("Produto: " + r.getCampo1() + " | Quantidade: " + r.getCampoNumerico() +
                        " | Funcionário: " + r.getCampo3() + " | Setor: " + r.getCampo4());
            }
        } else {
            System.out.println("Nenhum produto encontrado para a data '" + data + "' com detalhes ou ocorreu um erro.");
        }
    }
}