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

public class ControleDePilha {
    public static void main(String[] args) {

        Pilha normal = new Pilha(TipoLista.NORMAL);
        Pilha vip = new Pilha(TipoLista.VIP);
        Pilha preferencial = new Pilha(TipoLista.PREFERENCIAL);
        Pilha idoso = new Pilha(TipoLista.IDOSO);
        Pilha idoso80 = new Pilha(TipoLista.IDOSO80);
        Pilha urgente = new Pilha(TipoLista.URGENTE);

        Scanner scanner = new Scanner(System.in);

        while (true) { // adicionar mais opções
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

            switch (opcao) { // adicionar mais opções
                case 1:
                    System.out.println(normal.inserir());
                    break;
                case 2:
                    System.out.println(vip.inserir());
                    break;
                case 3:
                    System.out.println(preferencial.inserir());
                    break;
                case 4:
                    System.out.println(idoso.inserir());
                    break;
                case 5:
                    System.out.println(idoso80.inserir());
                    break;
                case 6:
                    System.out.println(urgente.inserir());
                    break;
                case 7:
                    if(!urgente.taVazia()){
                        System.out.println(urgente.chamar());
                    } else if (!idoso80.taVazia()) {
                        System.out.println(idoso80.chamar());
                    } else if (!idoso.taVazia()) {
                        System.out.println(idoso80.chamar());
                    } else if (!preferencial.taVazia()){
                        System.out.println(preferencial.chamar());
                    } else if (!vip.taVazia()) {
                        System.out.println(vip.chamar());
                    } else if (!normal.taVazia()){
                        System.out.println(normal.chamar());
                    }
                    break;
                case 8:
                    if (!urgente.taVazia()){
                        System.out.println(urgente.atender());
                    } else if (!idoso80.taVazia()) {
                        System.out.println(idoso80.atender());
                    } else if (!idoso.taVazia()) {
                        System.out.println(idoso80.atender());
                    } else if (!preferencial.taVazia()){
                        System.out.println(preferencial.atender());
                    } else if (!vip.taVazia()) {
                        System.out.println(vip.atender());
                    } else if (!normal.taVazia()){
                        System.out.println(normal.atender());
                    }
                    break;
                case 9:
                    System.out.println(urgente.listar());
                    System.out.println(idoso80.listar());
                    System.out.println(idoso.listar());
                    System.out.println(preferencial.listar());
                    System.out.println(vip.listar());
                    System.out.println(normal.listar());
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
}
