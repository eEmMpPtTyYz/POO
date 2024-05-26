/*
 * Disciplina Programação Orientada a Objetos
 * Autores:
 *      Matheus Gomes Lima RA 201566
 *      Felipe Ambruste Credendio  RA 197067
 *      Nicolas Ferreira da Silva  RA 194614
 * Atividade Final 3EC
 * Data 13/04/2024
 */
package AtividadeFinal;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ControleDePilha {
    public static void main(String[] args) {

        List<Pilha> pilhas = new ArrayList<>();
        pilhas.add(new Pilha(TipoLista.URGENTE));      // Prioridade 1
        pilhas.add(new Pilha(TipoLista.IDOSO80));      // Prioridade 2
        pilhas.add(new Pilha(TipoLista.IDOSO));        // Prioridade 3
        pilhas.add(new Pilha(TipoLista.PREFERENCIAL)); // Prioridade 4
        pilhas.add(new Pilha(TipoLista.VIP));          // Prioridade 5
        pilhas.add(new Pilha(TipoLista.NORMAL));       // Prioridade 6

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem Vindo ao consultório do Dr. No Problem, CRM 01.892");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerar senha comum");
            System.out.println("2. Gerar senha VIP");
            System.out.println("3. Gerar senha para preferencial");
            System.out.println("4. Gerar senha para idoso");
            System.out.println("5. Gerar senha para idoso80");
            System.out.println("6. Gerar senha para urgente");
            System.out.println("7. Chamar próxima senha");
            System.out.println("8. Atender senha");
            System.out.println("9. Para listar todas as senhas");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(pilhas.get(5).inserir());
                    break;
                case 2:
                    System.out.println(pilhas.get(4).inserir());
                    break;
                case 3:
                    System.out.println(pilhas.get(3).inserir());
                    break;
                case 4:
                    System.out.println(pilhas.get(2).inserir());
                    break;
                case 5:
                    System.out.println(pilhas.get(1).inserir());
                    break;
                case 6:
                    System.out.println(pilhas.get(0).inserir());
                    break;
                case 7:
                    chamarSenha(pilhas);
                    break;
                case 8:
                    atenderSenha(pilhas);
                    break;
                case 9:
                    listarSenhas(pilhas);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite uma opção valida");
                    break;
            }
        }
    }
    // 7
    private static void chamarSenha(List<Pilha> pilhas) {
        for (Pilha pilha : pilhas) {            
            if (!pilha.taVazia()) {
                System.out.println(pilha.chamar());
                return;
            }                           
        }
        System.out.println("Não há Senhas para chamar.");
    }
    // 8
    private static void atenderSenha(List<Pilha> pilhas) {
        for (Pilha pilha : pilhas) {
            if (!pilha.taVazia() && pilha.getTopo().getChamado()) {
                System.out.println(pilha.atender());
                return;
            }
        }
        System.out.println("A senha deve ser chamada primeiro");
    }

    private static void listarSenhas(List<Pilha> pilhas) {
        for (Pilha pilha : pilhas) {
            System.out.println(pilha.listar());
        }
    }
}
