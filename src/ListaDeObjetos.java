import java.util.ArrayList;

public class ListaDeObjetos<E extends Interface> {
    private ArrayList<E> lista;

    //Construtor
    public ListaDeObjetos() {
        lista = new ArrayList<>();
    }

    //Métodos

    public E getObjeto(int index) {
        return lista.get(index);
    }

    public void inserir(E objeto) {
        lista.add(objeto);
    }
    public void imprimirLista() {
        for(int i=0; i< lista.size(); i++) {
            lista.get(i).imprimeObjeto();
        }
    }

    public boolean quartoCadastrado(int numero) {
        for(int i=0; i<lista.size(); i++) {
            if(lista.get(i).compara(numero, 1)) {
                return true;
            }
        }
        return false;
    }

    public int buscaNumero(int numero, int tipo) {
        for(int i=0; i<lista.size(); i++) {
            if(lista.get(i).compara(numero,tipo)) {
                return i;
            }
        }
        return -1;
    }

    public void buscaNome(String nome, int tipo) {
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).equals(nome.toLowerCase())) {
                lista.get(i).imprimeObjeto();
            }
        }
    }
    public void buscaDisponibilidade(boolean ocupado, int tipo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).compara(ocupado, tipo)) {
                lista.get(i).imprimeObjeto();
            }
        }
    }

    public void excluir(int numero) {
        for(int i=0; i<lista.size(); i++) {
            if(lista.get(i).compara(numero, 1)) {
                lista.remove(i);
                System.out.println(lista.size());
                break;
            }
        }
    }
    public E localizaPorDisponibilidade(boolean disponibilidade) {
        for(int i=0; i< lista.size(); i++) {
            if(lista.get(i).compara(disponibilidade, 1)) {
                return lista.get(i);
            }
        }
        return null;
    }

    public E localizaPorNome(String nome) {
        for(int i=0; i< lista.size(); i++) {
            if(lista.get(i).compara(nome, 1)) {
                return lista.get(i);
            }
        }
        return null;
    }

    public E localizaPorNumero(int numero) {
        for(int i=0; i< lista.size(); i++) {
            if(lista.get(i).compara(numero, 1)) {
                return lista.get(i);
            }
        }
        return null;
    }

    //Por que nao pude usar size fora dessa classe sem criar um size aqui dentro

}
