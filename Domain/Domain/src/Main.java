import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>(); // Estanciando um arrayList do tipo Usuario.

        // Adicao dos usuarios para possivel efetuacao de login
        usuarios.add(new Usuario("Ari", "ari123"));
        usuarios.add(new Usuario("Carlos", "carlos123"));
        usuarios.add (new Usuario("Diego", "diego123"));
        usuarios.add(new Usuario("Erick", "erick123"));
        usuarios.add(new Usuario("Fabio", "fabio123"));

        int opt;

        do {

            // Tela inicial do sistema
            System.out.println("Seja bem vindo ao Sistema");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Atualizar Usuario");
            System.out.println("3 - Listar Usuarios");
            System.out.println("4 - Deletar Usuarios");
            System.out.println("5 - Sair");
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
                        usuarios.add(new Usuario(username, password));
                        System.out.println("Usuario Cadastrado com sucesso");
                    }
                }

                case 2 -> {
                    System.out.println("Informe o nome do usuario para atualizar");
                    String attUsuario = input.nextLine();

                    Usuario usuario = Usuario.buscarUsuario(attUsuario, usuarios);

                    if (usuario != null) {
                        System.out.println("Digite o novo username");
                        String novoUserName = input.nextLine();
                        System.out.println("Digite a nova senha");
                        String novoPassword = input.nextLine();
                        usuario.atualizarUsuario(novoUserName, novoPassword); // Agora só passa os novos valores
                    } else {
                        System.out.println("Usuario não encontrado");
                    }
                }

                case 3 -> {
                    // Case 3 Listando os usuarios
                    for (Usuario n : usuarios) {
                        System.out.println(n.getUsername() + "\n");
                    }
                }

                case 4 -> {
                    // Case 4 Deletar os usuarios
                    System.out.println("Informe o nome do usuario a deletar");
                    String usuarioDeletar = input.nextLine();
                    Usuario.deletarUsuario(usuarioDeletar, usuarios);
                }

                case 5 -> {
                    System.out.println("Saindo do Sistema!");
                    opt = 5;
                }
                default -> {
                    System.out.println("Opção invalida! Digite o que está sendo indicado como posição!!");
                }
            }

        } while (opt != 5);
        input.close();
    }

}