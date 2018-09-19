package com.github.jprnp.diretorio_listar_arquivos;

import java.io.File;
import java.util.ArrayList;

/**
 * Classe principal da aplicação.
 * @author jprnp
 */
public final class DiretorioListarArquivos {
    /**
     * Lista com os caminhos dos arquivos.
     */
    private static ArrayList<String> arquivos = new ArrayList<String>();
    /**
     * Status de retorno da execução do programa.
     */
    private static short status = 0;

    /**
     * Construtor privado p/ adequação com checkstyle.
     */
    private DiretorioListarArquivos() { }

    /**
     * Método de execução principal da aplicação.
     * @param args Argumentos passados ao programa
     */
    public static void main(final String[] args) {
        File dir = new File(".");
        search(dir);
        printArquivos();
        System.exit(status);
    }
    /**
     * Percorre o diretório em busca de arquivos.
     * @param dir O diretório a ser percorrido
     */
    public static void search(final File dir) {
        for (File file2 : dir.listFiles()) {
            if (file2.isDirectory()) {
                search(file2);
            } else {
            	arquivos.add(file2.getAbsolutePath());
            }
        }
    }
    /**
     * Imprime em tela o caminho para os diretórios.
     */
    public static void printArquivos() {
        arquivos.forEach(System.out::println);
    }
}
