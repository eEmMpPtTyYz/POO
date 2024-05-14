/*
 * Disciplina Programação Orientada a Objetos
 * Autores:
 *      Matheus Gomes Lima RA 201566
 *      Felipe Ambruste Credendio  RA 
 *      Nicolas Ferreira da Silva  RA 
 * Atividade Final 3EC
 * Data 13/04/2024
 */
package AtividadeFinal;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ControleDePilha {
    public static void main(String[] args) {

        Pilha consultorio = new Pilha();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem Vindo ao consultório do Dr. No Problem, CRM 01.892");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerar senha comum");
            System.out.println("2. Gerar senha emergencial");
            System.out.println("3. Gerar senha para idoso");
            System.out.println("4. Chamar próxima senha");
            System.out.println("5. Para listar todas as senhas");
            System.out.println("6. Sair");


            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Senha de prioridade normal criada\n");
                    consultorio.criaSenha(TipoLista.NORMAL);
                    break;
                case 2:
                    System.out.println("Senha de prioridade urgente criada\n");
                    consultorio.criaSenha(TipoLista.URGENTE);
                    break;
                case 3:
                    System.out.println("Senha de prioridade idoso criada\n");
                    consultorio.criaSenha(TipoLista.IDOSO);
                    break;
                case 4:
                    System.out.println(consultorio.chamar());
                    
                    break;
                case 5:
                    System.out.println(consultorio.listar());
                    
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    consultorio.criaSenha(TipoLista.NORMAL);
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}
