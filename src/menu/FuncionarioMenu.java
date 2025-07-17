package menu;



import dao.FuncionarioDAO;
import model.Funcionario;
import java.util.Scanner;
import java.util.ArrayList;

public class FuncionarioMenu {

    private static FuncionarioDAO dao = new FuncionarioDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU FUNCIONÁRIO ---");
            System.out.println("[1] Listar funcionários");
            System.out.println("[2] Buscar funcionário por ID");
            System.out.println("[3] Cadastrar funcionário");
            System.out.println("[4] Atualizar funcionário");
            System.out.println("[5] Remover funcionário");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    cadastrarFuncionario();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    removerFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = dao.listar();
        if (funcionarios != null && !funcionarios.isEmpty()) {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        } else {
            System.out.println("Nenhum funcionário encontrado.");
        }
    }

    private static void buscarPorId() {
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        Funcionario funcionario = dao.buscarPorId(id);
        if (funcionario != null) {
            System.out.println(funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome do funcionário: ");
        String sobrenome = scanner.nextLine();
        System.out.print("ID do setor: ");
        Integer idSetor = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        Funcionario funcionario = new Funcionario(nome, sobrenome, idSetor);
        if (dao.cadastrar(funcionario)) {
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }

    private static void atualizarFuncionario() {
        System.out.print("ID do funcionário a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        Funcionario funcionario = dao.buscarPorId(id);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        System.out.print("Novo nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Novo sobrenome do funcionário: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Novo ID do setor: ");
        Integer idSetor = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        funcionario.setNome(nome);
        funcionario.setSobrenome(sobrenome);
        funcionario.setIdSetor(idSetor);
        if (dao.atualizar(funcionario)) {
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar funcionário.");
        }
    }

    private static void removerFuncionario() {
        System.out.print("ID do funcionário a remover: ");
        int id = scanner.nextInt();
        if (dao.remover(id)) {
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Erro ao remover funcionário.");
        }
    }
}