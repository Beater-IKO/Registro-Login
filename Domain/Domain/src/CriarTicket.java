import java.util.Scanner;
import java.util.ArrayList;

// Enum que define os níveis de prioridade para os tickets
enum Prioridade {
    BAIXA, MEDIA, ALTA, GRAVE;
}

// Enum que define as áreas da faculdade (Interna ou Externa)
enum AreaFacul {
    INTERNA, EXTERNA;
}

// Classe Ticket, que representa os detalhes de um ticket de suporte
class Ticket {
    // Atributos privados da classe Ticket
    private String problema;
    private String sala;
    private AreaFacul areaFacul;
    private String andar;
    private Prioridade prioridade;
    private String detalhes;

    // Construtor da classe Ticket, que inicializa os valores de um ticket
    public Ticket(String problema, String sala, AreaFacul areaFacul, String andar, Prioridade prioridade,
            String detalhes) {
        this.problema = problema;
        this.sala = sala;
        this.areaFacul = areaFacul;
        this.andar = andar;
        this.prioridade = prioridade;
        this.detalhes = detalhes;
    }

    // Método para exibir as informações do ticket de forma formatada
    public void exibirTicket() {
        System.out.println(" Novo Ticket Criado");
        System.out.println("Problema: " + problema);
        System.out.println("Sala: " + sala);
        System.out.println("Área da Faculdade: " + areaFacul);
        System.out.println("Andar: " + andar);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Detalhes: " + detalhes);
        System.out.println("----------------------------------");
    }

    // Métodos getters e setters para encapsular os atributos privados

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public AreaFacul getAreaFacul() {
        return areaFacul;
    }

    public void setAreaFacul(AreaFacul areaFacul) {
        this.areaFacul = areaFacul;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}

// Classe principal que contém o menu e interação com o usuário
public class CriarTicket {
    /**
     * Método principal que inicia o sistema e permite ao usuário interagir
     */
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
                    AreaFacul areaFacul = null;
                    // Loop para garantir que a área da faculdade seja válida
                    while (areaFacul == null) {
                        try {
                            areaFacul = AreaFacul.valueOf(scanner.nextLine().toUpperCase()); // Recebe a entrada e tenta
                                                                                             // convertê-la para o enum
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: Área inválida.");
                            System.out.println("Digite a área da faculdade (Interna/Externa):");
                            areaFacul = null; // Redefine a variável para forçar nova entrada
                        }
                    }

                    System.out.println("Digite o andar:");
                    String andar = scanner.nextLine();

                    System.out.println("Digite a prioridade (BAIXA, MEDIA, ALTA, GRAVE):");
                    Prioridade prioridade = null;
                    // Loop para garantir que a prioridade seja válida
                    while (prioridade == null) {
                        try {
                            prioridade = Prioridade.valueOf(scanner.nextLine().toUpperCase()); // Recebe a entrada e
                                                                                               // tenta convertê-la para
                                                                                               // o enum
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: Prioridade inválida.");
                            System.out.println("Digite a prioridade (BAIXA, MEDIA, ALTA, GRAVE):");
                            prioridade = null; // Redefine a variável para forçar nova entrada
                        }
                    }

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
