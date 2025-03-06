import java.util.ArrayList;
import java.util.Scanner; // Importando a classe Scanner

public class ManipulacaoTickets {

    // Método que permite listar todos os tickets
    public static void listarTickets(ArrayList<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("Não há tickets para listar.");
        } else {
            System.out.println("\n=== Todos os Tickets ===");
            for (Ticket t : tickets) {
                t.exibirTicket();
            }
        }
    }

    // Método para editar um ticket
    public static void editarTicket(int index, Ticket ticket, Scanner scanner) {
        System.out.println("\nEditando o ticket número: " + (index + 1));
        System.out.println("Escolha o que deseja editar:");
        System.out.println("1- Problema");
        System.out.println("2- Sala");
        System.out.println("3- Área da Faculdade");
        System.out.println("4- Andar");
        System.out.println("5- Prioridade");
        System.out.println("6- Detalhes");
        System.out.print("Escolha uma opção: ");
        int opcaoEdicao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcaoEdicao) {
            case 1:
                System.out.println("Digite o novo problema:");
                ticket.setProblema(scanner.nextLine());
                break;
            case 2:
                System.out.println("Digite a nova sala:");
                ticket.setSala(scanner.nextLine());
                break;
            case 3:
                AreaFacul novaAreaFacul = null;
                while (novaAreaFacul == null) {
                    System.out.println("Digite a nova área da faculdade (Interna/Externa):");
                    try {
                        novaAreaFacul = AreaFacul.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Área inválida.");
                    }
                }
                ticket.setAreaFacul(novaAreaFacul);
                break;
            case 4:
                System.out.println("Digite o novo andar:");
                ticket.setAndar(scanner.nextLine());
                break;
            case 5:
                Prioridade novaPrioridade = null;
                while (novaPrioridade == null) {
                    System.out.println("Digite a nova prioridade (BAIXA, MEDIA, ALTA, GRAVE):");
                    try {
                        novaPrioridade = Prioridade.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Prioridade inválida.");
                    }
                }
                ticket.setPrioridade(novaPrioridade);
                break;
            case 6:
                System.out.println("Digite os novos detalhes:");
                ticket.setDetalhes(scanner.nextLine());
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        System.out.println("Ticket editado com sucesso!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Criando o Scanner
        ArrayList<Ticket> tickets = new ArrayList<>();
        
        // Exemplo de tickets existentes para testes
        tickets.add(new Ticket("Problema A", "Sala 101", AreaFacul.INTERNA, "1", Prioridade.MEDIA, "Detalhes A"));
        tickets.add(new Ticket("Problema B", "Sala 102", AreaFacul.EXTERNA, "2", Prioridade.ALTA, "Detalhes B"));

        // Interação do menu
        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1- Ver todos os Tickets");
            System.out.println("2- Editar Ticket");
            System.out.println("3- Sair");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listarTickets(tickets);
                    break;

                case 2:
                    if (tickets.isEmpty()) {
                        System.out.println("Não há tickets para editar.");
                    } else {
                        // Mostrar todos os tickets e permitir a edição
                        System.out.println("\nEscolha o número do ticket que deseja editar:");
                        for (int i = 0; i < tickets.size(); i++) {
                            System.out.println("Ticket " + (i + 1));
                            tickets.get(i).exibirTicket();
                        }
                        int escolha = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer

                        if (escolha < 1 || escolha > tickets.size()) {
                            System.out.println("Escolha inválida.");
                        } else {
                            Ticket ticketEscolhido = tickets.get(escolha - 1);
                            editarTicket(escolha - 1, ticketEscolhido, scanner);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo... Até mais!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
