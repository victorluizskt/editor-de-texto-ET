package view;

import model.StackList;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
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
                System.out.println("\t\tMenu: ");
                System.out.println("\t\t\t[1] Salvar arquivo.");
                System.out.println("\t\t\t[2] Imprimir arquivo no console.");
                System.out.println("\t\t\t[3] Ler um novo arquivo.");
                System.out.println("\t\t\t[0] Sair do programa.");
                System.out.print("\t\tOpção: ");
                option = input.nextInt();
                switch (option){
                    case 1:
                        System.out.println("\n\tQual nome deseja dar para o arquivo? (Não precisa digitar a extensão.)");
                        System.out.print("\tNome: ");
                        String nameArchive = input.next();
                        saveFile(nameArchive + ".txt");
                        break;
                    case 2:
                        printArchive();
                        break;
                    case 3:
                        Initializable();
                        break;
                    case 0:
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
        System.out.println("\n" + Objects.requireNonNull(revertText()).toString() + "\n");
    }

    private static void saveFile(String path){
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String text = revertText() + ".txt";
            buffWrite.append(text).append("\n");
            buffWrite.close();
            System.out.println("\tArquivo salvo com sucesso.\n");
        } catch(IOException e){
            System.out.println("Impossivel gravar arquivo, motivo: " + e.getMessage());
        }
    }

    private static StackList<String> revertText(){
        String list = stackList.toString();
        StackList<String> stackList1 = new StackList<>();
        if(list != null){
            for (int i = 0; i < list.length(); i++) {
                char c = list.charAt(i);
                stackList1.add(c+"");
            }
            return stackList1;
        }
        return null;
    }
}

