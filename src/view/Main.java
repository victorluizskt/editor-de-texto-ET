package view;

import model.StackList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static StackList<String> stackList = new StackList<>();
    static Scanner input = new Scanner(System.in);
    static String vet;

    public static void main(String[] args) {
        Initializable();
    }

    public static void Initializable(){
            try {
                workingFile();
                options();
            } catch(InputMismatchException e){
                System.out.println("Entrada inválida..");
            } catch(NullPointerException e){
                System.out.println("Lista vazia.");
            }
    }

    public static void workingFile(){
        vet = readArchive();
        if(vet != null) {
            for (int i = 0; i < vet.length(); i++) {
                char c = vet.charAt(i);
                if (c == '#')
                    stackList.pop();
                else if (c == '*')
                    stackList.add("\n");
                else if (c == '~') {
                    i = vet.length();
                } else
                    stackList.add(c + "");
            }
        }
    }

    public static String readArchive(){
        try {
                System.out.print("\tInforme o nome de arquivo texto: ");
                String nome = input.next();
                FileReader arq = new FileReader(nome);
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine(); // lê a primeira linha
                arq.close();
                if (linha != null) {
                    return linha;
                }
        } catch (IOException e) {
            System.err.printf("\tErro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return null;
    }

    public static void options(){
        int option;
        try {
            do {
                System.out.println("\t\t\t[1] Salvar arquivo.");
                System.out.println("\t\t\t[2] Imprimir arquivo no console.");
                System.out.println("\t\t\t[3] Ler um novo arquivo.");
                System.out.println("\t\t\t[0] Sair do programa.");
                System.out.print("\tOpção: ");
                option = input.nextInt();
                switch (option){
                    case 1:
                        saveFile();
                        break;
                    case 2:
                        printArchive();
                        break;
                    case 3:
                        Initializable();
                        break;
                    case 4:
                        System.out.println("Finalizando aplicação.");
                        break;
                    default:
                        System.out.println("Opção não identificada.");
                }
            } while(option != 0);
        } catch(InputMismatchException e){
            System.out.println("Opção inválida..");
        }
    }

    private static void printArchive() {
        System.out.println("\n" + stackList.toString() + "\n");
    }

    private static void saveFile() {
    }
}

