package AtividadeFinal;
/*
 * Disciplina Programação Orientada a Objetos
 * Autores:
 *      Matheus Gomes Lima RA 201566
 *      Felipe Ambruste Credendio  RA 
 *      Nicolas Ferreira da Silva  RA 
 * Atividade Final 3EC
 * Data 13/04/2024
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pilha extends EstrategiaLIFO {

    protected static TipoLista tipo;
    
    private LinkedList<Senha> fila = new LinkedList<Senha>();

    

   

    public void criaSenha(TipoLista type){
        
        tipo = type;
        inserir();  
    }

    

    @Override
    public String inserir() {
        Senha senha = new Senha();
        senha.gerarSenha();
        System.out.println("Sua senha: " + senha.retornarSenha());
        if(tipo == TipoLista.URGENTE){
            fila.addFirst(senha);
        }else{
            fila.add(senha);
        }
        
        return senha.retornarSenha();
    }

    @Override
    public void remover() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public String chamar() {
        if (fila.isEmpty()){
            return "a fila esta vazia";
        }
         
        return "chamando: " + fila.poll().retornarSenha();
    }

    @Override
    public String atender() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atender'");
    }

    @Override
    public String listar() {
        return fila.toString();
    }
    
}
