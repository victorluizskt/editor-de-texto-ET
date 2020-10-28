package view;

import model.StackList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static StackList<String> stackList = new StackList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        main();
    }
    public static void main(){
        int confirmation = -1;
        do {
            try{
                String vet = "Este et# um teste para o ET, o extraterrestre\n" +
                        "em Java.*Acabamos de testar a capacidade de o\n" +
                        "ET saltar de linha, utilizando seus poderes\n" +
                        "extras (cuidado, pois agora vamos estourar a\n" +
                        "capacidade máxima da linha de impressão, que é\n" +
                        "de 70 caracteres.)*O k#cut#rso dh#e\n" +
                        "Estruturas de Dados et# h#um cuu#rsh#o #x# x?\n" +
                        "*!#?!#+.* Como et# bom n#nt#ao### r#ess#tt#ar\n" +
                        "mb#aa#triz#cull#ado nn#x#ele!\\ Sera que este\n" +
                        "funciona\\\\\\? O sinal? não### deve ficar! ~";
                for(int i = 0; i < vet.length(); i++){
                    char c = vet.charAt(i);
                    if(c == '#')
                        stackList.pop();
                    else if(c == '*')
                        stackList.add("\n");
                    else if(c == '~') {
                        System.out.println(stackList.toString());
                        confirmation = 0;
                    } else
                        stackList.add(c+"");
                }
                confirmation = input.nextInt();
                if(confirmation == 0)
                    System.out.println(stackList.toString());
            } catch(InputMismatchException e){
                System.out.println("Input invalid.");
            } catch(NullPointerException e){
                System.out.println("List is null");
            }
        } while(confirmation != 0);
    }
}
