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

        System.out.println("Infome seu usuario: ");
        String nomeUsuario = input.nextLine();

        System.out.println("Informe sua senha: ");
        String senhaUsuario = input.nextLine();

        Usuario aluno = new Aluno(nomeUsuario, senhaUsuario);

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

                    String NomeAdm = "adm123";
                    String SenhaAdm = "adm123";

                    String NomeAgente = "agente123";
                    String SenhaAgente = "agente123";

                    System.out.println("Login....");

                    System.out.println("Digite o nome de usuario:");
                    String LoginUsuario = input.nextLine();
                    System.out.println("Digite a senha: ");
                    String LoginSenha = input.nextLine();

                    if (LoginUsuario.equals(NomeAdm) && LoginSenha.equals(SenhaAdm)) {
                        System.out.println("Login de administrador bem-sucedido!");

                    } else {

                        if (LoginUsuario.equals(NomeAgente) && LoginSenha.equals(SenhaAgente)) {
                            System.out.println("Login de agente de campo bem-sucedido");

                        } else {

                            if (usuarios.equals(LoginUsuario) && usuarios.equals(LoginSenha)) {
                                System.out.println("Logado com sucesso!");
                            } else {
                                System.out.println("Nome ou senha incorretes!");

                            }

                        }

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