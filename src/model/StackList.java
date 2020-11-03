package model;

/*
 *
 * @brief Classe StackList
 * @author Victor Luiz Gonçalves
 * @date   03/11/2020
 * @since  03/11/2020
 *
 */

/**
 *  Classe simples que implementa uma pilha, para as funcionalidades da Main.
 */

public class StackList<T> {

    public class Head{
        public T item;
        public Head prox;
    }

    private Head top;
    private long size;

    public void add(T item){
        if(item == null){
            throw new NullPointerException("Item is null");
        } else{
            Head head = new Head();
            head.item = item;
            head.prox = top;
            top = head;
            size++;
        }
    }

    public T pop(){
        if(isNull()){
            throw new NullPointerException("List is null");
        } else {
            T aux = top.item;
            top = top.prox;
            size--;
            return aux;
        }
    }

    public boolean isNull() {
        return top == null;
    }

    public String toString(){
        Head aux = top;
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        while(cont < this.size){
             sb.append(aux.item);
             aux = aux.prox;
             cont++;
         }
        return sb.toString();
    }

}
