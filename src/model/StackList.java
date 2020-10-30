package model;

import java.util.Stack;

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

    public void pop(){
        if(isNull()){
            throw new NullPointerException("List is null");
        } else {
            top = top.prox;
            size --;
        }
    }

    public void removeLine(){
        if(isNull()){
            throw new NullPointerException("List is null");
        } else {
            Head aux = top;
            int cont = 0;
            String verified, verified1 = "";
            while(cont < this.size){
                if(aux.item.equals("\n")){
                    verified = "ok";
                }
                aux = aux.prox;
                if(aux.item.equals("\n")){
                    verified1 = "ok";
                }
                cont++;
            }
        }
    }

    private boolean isNull() {
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
