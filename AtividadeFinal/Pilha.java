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

import java.util.LinkedList;


public class Pilha extends EstrategiaLIFO {

    private final TipoLista tipo;

    private final LinkedList<Senha> pilha;




    public Pilha(TipoLista type) {
        tipo = type;
        pilha = new LinkedList<Senha>();
    }


    @Override
    public String inserir() {
        Senha senha = new Senha();
        senha.gerarSenha();
        pilha.addFirst(senha);

        return "Senha gerada:\n"+ tipo.tipo+ "-" + senha.retornarSenha();
    }

    public boolean taVazia(){
        return (pilha.isEmpty());
    }

    @Override
    public void remover() { //?
        pilha.removeFirst();
    }

    @Override
    public String chamar() {
        if(!taVazia()){
            pilha.getFirst().setChamado();
            return "chamando:\n"+ tipo.tipo + "-" + pilha.getFirst().retornarSenha();
        }
        return "A pilha esta vazia";
    }

    @Override
    public String atender() {
        String atendendo = "Atendendo: \n" + tipo.tipo + "-" + pilha.getFirst().retornarSenha();
        if(!pilha.getFirst().getChamado()){
            return "A Senha não foi chamada";
        }
        remover();
        return atendendo;
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append(tipo.tipo+"(").append(pilha.size()).append("): ").append(getSenhas(pilha)).append("\n");
        return sb.toString();
    }

    private String getSenhas(LinkedList<Senha> p) {
        StringBuilder sb = new StringBuilder();
        for (Senha senha : p) {
            sb.append(tipo.tipo + "-" + senha.retornarSenha()).append(", ");
        }
        return sb.toString().trim();
    }
}
