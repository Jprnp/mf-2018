package com.github.jprnp.diretorio_lista_dirs;

import java.io.File;
import java.util.ArrayList;

/**
 * Classe principal da aplicação.
 * @author jprnp
 */
public final class DiretorioListaDirs {
    /**
     * Lista com os caminhos dos diretórios.
     */
    private static ArrayList<String> diretorios = new ArrayList<String>();
    /**
     * Status de retorno da execução do programa.
     */
    private static short status = 0;

    /**
     * Construtor privado p/ adequação com checkstyle.
     */
    private DiretorioListaDirs() { }

    /**
     * Método de execução principal da aplicação.
     * @param args Argumentos passados ao programa
     */
    public static void main(final String[] args) {
        File dir = new File(".");
        search(dir);
        printDirs();
        System.exit(status);
    }
    /**
     * Percorre o diretório em busca de outros diretórios.
     * @param dir O diretório a ser percorrido
     */
    public static void search(final File dir) {
        diretorios.add(dir.getAbsolutePath());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                search(file);
            }
        }
    }
    /**
     * Imprime em tela o caminho para os diretórios.
     */
    public static void printDirs() {
        diretorios.forEach(System.out::println);
    }
}
