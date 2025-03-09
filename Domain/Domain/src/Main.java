
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>(); // Estanciando um arrayList do tipo Usuario.

        // Adicao dos usuarios para possivel efetuacao de login
        usuarios.add(new Admin("Ari", "ari123"));
        usuarios.add(new Aluno("Carlos", "carlos123"));
        usuarios.add(new Aluno("Diego", "diego123"));
        usuarios.add(new Aluno("Erick", "erick123"));
        usuarios.add(new Aluno("Fabio", "fabio123"));

        int opt;

        do {

            // Tela inicial do sistema
            System.out.println("Seja bem vindo ao Sistema");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Entrar com Login");
            System.out.println("Selecione uma opção");
            opt = input.nextInt();
            input.nextLine();

            switch (opt) {
                case 1 -> {
                    // Case 1 Cadastro de um novo usuario
                    System.out.println("Digite o username");
                    String username = input.nextLine();

                    if (Usuario.buscarUsuario(username, usuarios) != null) {
                        System.out.println("Erro: Username ja existente na lista!");
                    } else {
                        System.out.println("Digite o password");
                        String password = input.nextLine();
                        usuarios.add(new Aluno(username, password));
                        System.out.println("Usuario Cadastrado com sucesso");
                    }
                }

                case 2 -> {
                    System.out.println("Login....");

                    System.out.println("Digite o nome de usuario:");
                    String LoginUsuario = input.nextLine();
                    System.out.println("Digite a senha: ");
                    String LoginSenha = input.nextLine();

                    Usuario usuario = Usuario.buscarUsuario(LoginUsuario, usuarios);
                    if (usuario != null && usuario.autenticar(LoginSenha)) {
                        System.out.println("Logado com sucesso!");
                        usuario.mostrarDetalhes();
                        if (usuario instanceof Aluno) {
                            CriarTicket.main(new String[0]); // Chama o menu de criação de tickets
                        } else if (usuario instanceof Admin) {
                            ManipulacaoTickets.main(new String[0]); // Chama o menu de manipulação de tickets
                        }
                    } else {
                        System.out.println("Nome ou senha incorretos!");
                    }
                }

                default -> {
                    System.out.println("Opção invalida! Digite o que está sendo indicado como posição!!");
                }
            }

        } while (opt != 5);
        input.close();
    }

}
