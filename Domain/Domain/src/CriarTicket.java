import java.util.Scanner;
import java.util.ArrayList;

// Classe Ticket, que representa os detalhes de um ticket de suporte
class Ticket {
    String problema;
    String sala;
    String areaFacul;
    String andar;
    String prioridade;
    String detalhes;

    // Construtor da classe Ticket, que inicializa os valores de um ticket
    public Ticket(String problema, String sala, String areaFacul, String andar, String prioridade, String detalhes) {
        this.problema = problema;
        this.sala = sala;
        this.areaFacul = areaFacul;
        this.andar = andar;
        this.prioridade = prioridade;
        this.detalhes = detalhes;
    }

    // Método para exibir as informações do ticket de forma formatada
    public void exibirTicket() {
        System.out.println("🚨 Novo Ticket Criado 🚨");
        System.out.println("Problema: " + problema);
        System.out.println("Sala: " + sala);
        System.out.println("Área da Faculdade: " + areaFacul);
        System.out.println("Andar: " + andar);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Detalhes: " + detalhes);
        System.out.println("----------------------------------");
    }

}

// Classe principal que contém o menu e interação com o usuário
public class CriarTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para ler as entradas do usuário
        ArrayList<Ticket> tickets = new ArrayList<>(); // Lista para armazenar os tickets criados

        // Loop principal do menu, onde o programa continuará executando até o usuário
        // escolher sair
        while (true) {
            // Exibição do menu com as opções para o usuário escolher
            System.out.println("\n==== Menu ====");
            System.out.println("1- Ver todos meus Tickets");
            System.out.println("2- Criar novo Ticket");
            System.out.println("3- Sair");
            System.out.print("\nEscolha uma opção: "); // Solicita a opção ao usuário
            int opcao = scanner.nextInt(); // Lê a opção selecionada
            scanner.nextLine(); // Limpa a linha do buffer após o nextInt()

            // Switch para verificar a opção selecionada
            switch (opcao) {
                // Caso o usuário queira ver todos os tickets
                case 1:
                    if (tickets.isEmpty()) { // Verifica se a lista de tickets está vazia
                        System.out.println("\nA lista de tickets está vazia.");
                    } else {
                        System.out.println("\n=== Todos os Tickets ===");
                        for (Ticket t : tickets) { // Percorre todos os tickets e exibe suas informações
                            t.exibirTicket();
                        }
                    }
                    break;

                // Caso o usuário queira criar um novo ticket
                case 2:
                    // Solicita as informações para criar um novo ticket
                    System.out.println("\nDigite o problema:");
                    String problema = scanner.nextLine();

                    System.out.println("Digite a sala:");
                    String sala = scanner.nextLine();

                    System.out.println("Digite a área da faculdade (Interna/Externa):");
                    String areaFacul = scanner.nextLine();

                    System.out.println("Digite o andar:");
                    String andar = scanner.nextLine();

                    System.out.println("Digite a prioridade (Baixa/Média/Alta):");
                    String prioridade = scanner.nextLine();

                    System.out.println("Digite detalhes adicionais:");
                    String detalhes = scanner.nextLine();

                    // Cria um novo objeto Ticket com as informações fornecidas
                    Ticket ticket = new Ticket(problema, sala, areaFacul, andar, prioridade, detalhes);
                    tickets.add(ticket); // Adiciona o ticket à lista de tickets
                    System.out.println("\nTicket criado com sucesso!\n"); // Mensagem de confirmação
                    break;

                // Caso o usuário escolha sair
                case 3:
                    System.out.println("\nSaindo... Até mais!"); // Exibe uma mensagem de despedida
                    scanner.close(); // Fecha o scanner para liberar recursos
                    return; // Encerra a execução do programa

                // Caso o usuário insira uma opção inválida
                default:
                    System.out.println("\nOpção inexistente. Tente novamente.");
                    break;
            }
        }
    }
}
