package view;

/*
 *
 * @brief Classe Main
 * @author Victor Luiz Gonçalves
 * @date   03/11/2020
 * @since  03/11/2020
 *
 *  O texto TXT deve ser escrito em apenas 1 LINHA(et.txt é um exemplo de como o arquivo deve ser escrito)
 * para que o programa não considere '\n' como caracter.
 */

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


    /**
     * Metódo responsável por iniciar a aplicação na main.
     */
    private static void Initializable(){
            try {
                workingFile();
                options();
            } catch(InputMismatchException e){
                System.out.println("Entrada inválida..");
            } catch(NullPointerException e){
                System.out.println("Lista vazia.");
            }
    }

    /**
     * Metódo responsável pela leitura e salvamento do arquivo, já de maneira légivel sem caracteres especiais.
     */
    private static void workingFile(){
        vet = readArchive();
        if(vet != null) {
            for (int i = 0; i < vet.length(); i++) {
                char c = vet.charAt(i);
                if (c == '#')
                    stackList.pop();
                else if (c == '*') {
                    char w = '&';
                    stackList.add("\n");
                    stackList.add(w + ""); // Adiciona o E comercial para que na remoção dos \\ eu tenha um ponto de parada.
                }else if (c == '~') {
                    i = vet.length(); // Se ouver ~ i = vet.length para finalizar a leitura.
                }else if (c == '\\') {
                    String y;
                        do {
                             y = stackList.pop();
                        } while (!y.equals("&"));
                    }
                else
                    stackList.add(c + "");
            }
        }
    }

    /**
     * Leitura simples de arquivo usando FileReader/BufferedReader
     */
    private static String readArchive(){
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

    /**
     *  Menu de opções do user.
     */
    private static void options(){
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
                        saveFile(nameArchive + ".txt"); // Usa o .txt para salvar a extensão do arquivo.
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

    /**
     * Função de impressão verificando se a mesma não é nula com Objects.requireNonNull
     */
    private static void printArchive() {
        System.out.println("\n" + Objects.requireNonNull(revertText()).toString() + "\n");
    }

    /**
     * Método que salva escreve os arquivos em um txt na raiz do projeto.
     * @param path Texto que será escrito no txt.
     */
    private static void saveFile(String path){
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            String text = revertText() + "";
            buffWrite.append(text).append("\n");
            buffWrite.close();
            System.out.println("\tArquivo salvo com sucesso.\n");
        } catch(IOException e){
            System.out.println("Impossivel gravar arquivo, motivo: " + e.getMessage());
        }
    }

    /**
     * Método responsável por reverter o texto, sendo assim de maneira que possamos ler.
     */
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

