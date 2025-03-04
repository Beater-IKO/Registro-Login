import java.util.Scanner;

public class Admin {
    public static void main(String[] args) {
        System.out.println("1-Atualizar Tickect \n2-Listar Tickects\n 3-Deletar Tickects");
        // ARRAY DE EXEMPLO PARA TICKECTS
        int TICKECTS[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // VARIAVEL PARA ESCOLHA DE MENU
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("EM CONSTRUÇÂO");
                break;
            case 2:
                // ARRAY DE EXEMPLO...
                for (int Num : TICKECTS) {
                    System.out.println(Num);
                }
                break;
            default:
                System.out.println("OPÇÃO INEXISTENTE");
                break;
        }

    }

}