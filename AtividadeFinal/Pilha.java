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

    private String COLOR = "\033[0m";
    private String RESET = "\033[0m";


    public Pilha(TipoLista type) {
        tipo = type;
        pilha = new LinkedList<Senha>();
        setColor(type);
    }

    TipoLista getTipo(){
        return tipo;
    }

    public Senha getTopo(){
        return pilha.getFirst();
    }


    @Override
    public String inserir() {
        Senha senha = new Senha();
        senha.gerarSenha();
        pilha.addFirst(senha);

        return "Senha gerada:\n"+ COLOR + tipo.tipo+ "-" + senha.retornarSenha() + RESET;
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
            getTopo().setChamado();
            return "chamando:\n"+ COLOR + tipo.tipo + "-" + getTopo().retornarSenha() + RESET;
        }
        return "A pilha esta vazia";
    }

    @Override
    public String atender() {
        String atendendo = "Atendendo: \n"+ COLOR + tipo.tipo + "-" + getTopo().retornarSenha() + RESET;
        if(getTopo().getChamado()){
            remover();
            return atendendo;
        }
        return "A Senha não foi chamada";
        
    }

    @Override
    public String listar() {
        StringBuilder sb = new StringBuilder();
        sb.append(tipo.tipo+"(").append(pilha.size()).append("): "+ COLOR).append(getSenhas(pilha)).append("\n"+RESET);
        return sb.toString();
    }

    private String getSenhas(LinkedList<Senha> p) {
        StringBuilder sb = new StringBuilder();
        for (Senha senha : p) {
            sb.append(tipo.tipo + "-" + senha.retornarSenha()).append(", ");
        }
        return sb.toString().trim();
    }
    private void setColor(TipoLista type){
        if(type == TipoLista.URGENTE){
            COLOR = "\033[0;31m";
        } else if (type == TipoLista.IDOSO80) {
            COLOR = "\033[0;35m";
        } else if (type == TipoLista.IDOSO) {
            COLOR = "\033[0;34m";
        } else if (type == TipoLista.PREFERENCIAL){
            COLOR = "\033[0;36m";
        } else if (type == TipoLista.VIP) {
            COLOR = "\033[0;33m";
        } else if (type == TipoLista.NORMAL){
            COLOR = "\033[0;32m";
        }
    }
}
