import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    private String descricao;
    private String status; // "Pendente", "Lido", "Em andamento", "Finalizado"

    public Ticket(String descricao) {
        this.descricao = descricao;
        this.status = "Pendente"; // Status inicial
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void mostrarDetalhes() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
    }
}

class Tickets {
    private ArrayList<Ticket> ticketsPendentes;

    public Tickets() {
        ticketsPendentes = new ArrayList<>();
        // Adicionando tickets de exemplo
        ticketsPendentes.add(new Ticket("Janela Quebrada - 3º Andar - Interna - Sala 310"));
        ticketsPendentes.add(new Ticket("Cadeira Quebrada - 3º Andar - Interna - Sala 310"));
        ticketsPendentes.add(new Ticket("Piso Quebrado - 2º Andar - Interna - Sala 215"));
    }

    public void visualizarTickets() {
        System.out.println("Tickets Pendentes:");
        for (int i = 0; i < ticketsPendentes.size(); i++) {
            System.out.println((i + 1) + ". " + ticketsPendentes.get(i).getDescricao() + " ["
                    + ticketsPendentes.get(i).getStatus() + "]");
        }
    }

    public void abrirTicket(int indice, Scanner scanner) {
        if (indice < 1 || indice > ticketsPendentes.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Ticket ticketSelecionado = ticketsPendentes.get(indice - 1);
        ticketSelecionado.mostrarDetalhes();

        System.out.println("O que deseja fazer com este ticket?");
        System.out.println("1- Marcar como Lido");
        System.out.println("2- Marcar como Em andamento");
        System.out.println("3- Marcar como Finalizado");
        System.out.println("4- Voltar");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                ticketSelecionado.setStatus("Lido");
                break;
            case 2:
                ticketSelecionado.setStatus("Em andamento");
                break;
            case 3:
                ticketSelecionado.setStatus("Finalizado");
                ticketsPendentes.remove(indice - 1); // Remove da lista de pendentes
                break;
            default:
                System.out.println("Voltando...");
                break;
        }
    }

    public static void visualizarTicketsRealizados() {
        System.out.println("Mesa Quebrada - 3º Andar - Interna - Sala 312");
    }
}

public class AgenteDeCampo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Visualizar Tickets Pendentes");
            System.out.println("2 - Visualizar Tickets Realizados");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tickets.visualizarTickets();
                    System.out.print("Escolha um ticket para abrir (ou 0 para voltar): ");
                    int escolha = scanner.nextInt();
                    if (escolha != 0) {
                        tickets.abrirTicket(escolha, scanner);
                    }
                    break;
                case 2:
                    Tickets.visualizarTicketsRealizados();
                    break;
                case 3:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        scanner.close();
    }
}