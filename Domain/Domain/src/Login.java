import java.util.Scanner;

class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    // public boolean validarSenha(String tentativa) {
    // return this.senha.equals(tentativa);
    // }
}

public class Login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Infome seu usuario: ");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Informe sua senha: ");
        String senhaUsuario = scanner.nextLine();

        Usuario usuario = new Usuario(nomeUsuario, senhaUsuario);

        scanner.close();

    }
}