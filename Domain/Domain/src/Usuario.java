import java.util.ArrayList;

public abstract class Usuario implements Autenticar {

    private String username;
    private String password;

    public Usuario(){

    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(Usuario novo){
        this.username = novo.username;
        this.password = novo.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Verifica se os usuarios tem nomes iguais se isso ocorrer ele impede a criação
    // de um novo user
    public static Usuario buscarUsuario(String username, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }

    public abstract void mostrarDetalhes();

    // Atualização do usuario;
    public void atualizarUsuario(String novoUserName, String novoPassword) {
        this.username = novoUserName;
        this.password = novoPassword;
        System.out.println("Usuário Atualizado com sucesso!");
    }

    // Deletar o usuario;
    public static void deletarUsuario(String username, ArrayList<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsername().equals(username)) {

                usuarios.remove(i);
                System.out.println("Usuário removido com sucesso!");
            }
        }
        System.out.println("Usuário não encontrado!");
    }

}