import menu.SetorMenu;
import menu.FuncionarioMenu;
import menu.ProdutoMenu;
import menu.ProducaoMenu;
import menu.RelatorioMenu; // Descomentar esta linha se criar a classe RelatorioMenu

import java.util.Scanner;

public class AppIndustria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao; // Declara a variável 'opcao' fora do loop para ser acessível no do-while

        do {
            System.out.println("\n--- MENU PRINCIPAL - APP INDÚSTRIA ---");
            System.out.println("[1] Produção");
            System.out.println("[2] Funcionários");
            System.out.println("[3] Setores");
            System.out.println("[4] Produtos");
            System.out.println("[5] Relatórios");
            System.out.println("[0] Sair"); // Alterado para [0] para sair, conforme sua lógica de 'opcao == 0'
            System.out.print("Opção: ");

            opcao = sc.nextInt(); // Lê a opção
            sc.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    ProducaoMenu.main(args);
                    break;
                case 2:
                    FuncionarioMenu.main(args);
                    break;
                case 3:
                    SetorMenu.main(args);
                    break;
                case 4:
                    ProdutoMenu.main(args);
                    break;
                case 5:
                    // Se você criar uma classe RelatorioMenu, chame-a aqui:
                    RelatorioMenu.main(args);
                    System.out.println("Funcionalidade de Relatórios não implementada ainda.");
                    break;
                case 0: // Opção para sair
                    System.out.println("Programa finalizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0); // O loop continua enquanto a opção não for 0

        sc.close(); // Fecha o scanner ao sair do programa
    }
}
