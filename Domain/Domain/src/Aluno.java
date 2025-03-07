public class Aluno extends Usuario {

    public Aluno(String username, String password) {
        super(username, password);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Aluno: " + getUsername());
    }

    @Override
    public boolean autenticar(String password) {
        return password.equals(getPassword());
    }
}