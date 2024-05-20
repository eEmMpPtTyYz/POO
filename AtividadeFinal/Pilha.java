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
import java.util.Queue;

public class Pilha extends EstrategiaLIFO {

    protected static TipoLista tipo;
    
    private LinkedList<Senha> filaNomal = new LinkedList<Senha>();
    private LinkedList<Senha> filaPreferencial = new LinkedList<Senha>();
    private LinkedList<Senha> filaUrgente = new LinkedList<Senha>();
    private LinkedList<Senha> filaIdoso = new LinkedList<Senha>();
    private LinkedList<Senha> filaIdoso80 = new LinkedList<Senha>();
    private LinkedList<Senha> filaVip = new LinkedList<Senha>();

    

   

    public void criaSenha(TipoLista type){
        
        tipo = type;
        inserir();
    }

    

    @Override
    public String inserir() {
        Senha senha = new Senha();
        senha.gerarSenha();
        System.out.println("Sua senha: ");
        if(tipo == TipoLista.NORMAL){
            filaNomal.add(senha);

        }else if(tipo == TipoLista.URGENTE){
            filaUrgente.add(senha);
        }else if(tipo == TipoLista.VIP){
            filaVip.add(senha);
        }else if(tipo == TipoLista.IDOSO){
            filaIdoso.add(senha);
        }else if(tipo == TipoLista.IDOSO80){
            filaIdoso80.add(senha);
        }else if(tipo == TipoLista.PREFERENCIAL){
            filaPreferencial.add(senha);
        }
        System.out.println(tipo.tipo +" "+ senha.retornarSenha());
        return tipo.tipo+ " " + senha.retornarSenha();
    }

    @Override
    public void remover() { //?
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public String chamar() {
        if (!filaUrgente.isEmpty()){
            return "chamando: URG " + filaUrgente.poll().retornarSenha();
        }else if (!filaIdoso80.isEmpty()){
            return "chamando: I80 " + filaIdoso80.poll().retornarSenha();
        }else if (!filaIdoso.isEmpty()){
            return "chamando: I60 " + filaIdoso.poll().retornarSenha();
        }else if (!filaPreferencial.isEmpty()){
            return "chamando: PFL " + filaPreferencial.poll().retornarSenha();
        }else if (!filaVip.isEmpty()){
            return "chamando: VIP " + filaVip.poll().retornarSenha();
        }else if (!filaNomal.isEmpty()){
            return "chamando: NML " + filaNomal.poll().retornarSenha();
        }
         
        return "Não tem ninguem na fila";
    }

    @Override
    public String atender() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atender'");
    }

    @Override
    public String listar() { //adicionar as outras filas
        return filaUrgente.toString() + filaNomal.toString();
    }
    
}
