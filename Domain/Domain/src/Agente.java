public class Agente extends Usuario {

    public Agente(String username, String password){
        super(username, password);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Agente de campo: " + getUsername());
    }

    @Override
    public boolean autenticar(String password) {
        return password.equals(getPassword());
    }
}
