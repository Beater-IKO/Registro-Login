
public class Admin extends Usuario {

    public Admin(String username, String password) {
        super(username, password);

    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Administrador: " + getUsername());
    }

    @Override
    public boolean autenticar(String password) {
        return password.equals(getPassword());
    }
}
