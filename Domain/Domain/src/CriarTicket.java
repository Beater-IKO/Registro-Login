import java.util.Scanner;
import java.util.ArrayList;

class Ticket {
    String problema;
    String sala;
    String areaFacul;
    String andar;
    String prioridade;
    String detalhes;

    public Ticket(String problema, String sala, String areaFacul, String andar, String prioridade, String detalhes) {
        this.problema = problema;
        this.sala = sala;
        this.areaFacul = areaFacul;
        this.andar = andar;
        this.prioridade = prioridade;
        this.detalhes = detalhes;
    }

    public void exibirTicket() {
        System.out.println(" Novo Ticket Criado ");
        System.out.println("Problema: " + problema);
        System.out.println("Sala: " + sala);
        System.out.println("Área da Faculdade: " + areaFacul);
        System.out.println("Andar: " + andar);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Detalhes: " + detalhes);
        System.out.println("----------------------------------");
    }

}

public class CriarTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();
        while (true) {
            System.out.println(" 1- Ver todos meus Tickets \n 2- Criar novo Ticket\n 3-Sair");
            int opcao = 0;
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    if (tickets.isEmpty()) {
                        System.out.println("A lista se encontra vazia");
                    } else {
                        System.out.println("Todos os Tickets");
                        for (Ticket t : tickets) {
                            t.exibirTicket();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite o problema:");
                    String problema = scanner.nextLine();

                    System.out.println("Digite a sala:");
                    String sala = scanner.nextLine();

                    System.out.println("Digite a área da faculdade:");
                    String areaFacul = scanner.nextLine();

                    System.out.println("Digite o andar:");
                    String andar = scanner.nextLine();

                    System.out.println("Digite a prioridade (Baixa/Média/Alta):");
                    String prioridade = scanner.nextLine();

                    System.out.println("Digite detalhes adicionais:");
                    String detalhes = scanner.nextLine();
                    Ticket ticket = new Ticket(problema, sala, areaFacul, andar, prioridade, detalhes);
                    tickets.add(ticket);
                    System.out.println("Ticket criado com sucesso");
                    ;
                    break;
                case 3:
                    System.out.println("Saindo....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcao inexistente");
                    break;
            }

        }
    }
}
