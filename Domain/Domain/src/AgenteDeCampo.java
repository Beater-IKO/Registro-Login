import java.util.ArrayList;
import java.util.Scanner;

// Classe que representa um Ticket
class TicketAgente {
    private String descricao;
    private String status; // "Pendente", "Lido", "Em andamento", "Finalizado"

    // Construtor para inicializar um ticket com descrição e status inicial como
    // "Pendente"
    public TicketAgente(String descricao) {
        this.descricao = descricao;
        this.status = "Pendente";
    }

    // Métodos getter para obter os valores dos atributos
    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    // Método para atualizar o status do ticket
    public void setStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Método para exibir os detalhes do ticket
    public void mostrarDetalhes() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
    }
}

// Classe que gerencia os tickets
class TicketsAgente {
    private ArrayList<TicketAgente> ticketsPendentes; // Lista de tickets pendentes

    // Construtor para inicializar a lista e adicionar alguns tickets de exemplo
    public TicketsAgente() {
        ticketsPendentes = new ArrayList<>();
        ticketsPendentes.add(new TicketAgente("Janela Quebrada - 3º Andar - Interna - Sala 310"));
        ticketsPendentes.add(new TicketAgente("Cadeira Quebrada - 3º Andar - Interna - Sala 310"));
        ticketsPendentes.add(new TicketAgente("Piso Quebrado - 2º Andar - Interna - Sala 215"));
    }

    // Método para exibir todos os tickets pendentes
    public void visualizarTickets() {
        System.out.println("Tickets Pendentes:");
        for (int i = 0; i < ticketsPendentes.size(); i++) {
            System.out.println((i + 1) + ". " + ticketsPendentes.get(i).getDescricao() + " ["
                    + ticketsPendentes.get(i).getStatus() + "]");
        }
    }

    // Método para abrir um ticket e alterar seu status
    public void abrirTicket(int indice, Scanner scanner) {
        if (indice < 1 || indice > ticketsPendentes.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        TicketAgente ticketSelecionado = ticketsPendentes.get(indice - 1);
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
                ticketsPendentes.remove(indice - 1); // Remove o ticket concluído da lista
                break;
            default:
                System.out.println("Voltando...");
                break;
        }
    }

    // Método para visualizar tickets já realizados (por enquanto, apenas um exemplo
    // fixo)
    public static void visualizarTicketsRealizados() {
        System.out.println("Mesa Quebrada - 3º Andar - Interna - Sala 312");
    }
}

// Classe principal para executar o programa
public class AgenteDeCampo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketsAgente tickets = new TicketsAgente();
        int opcao;

        // Loop do menu principal
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
                    TicketsAgente.visualizarTicketsRealizados();
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
