package com.github.jprnp.conta_linhas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Classe principal da aplicação.
 * @author jprnp João Pedro Pinheiro
 */
public final class ContaLinhas {
    /**
     * Status de retorno - Sucesso.
     */
    public static final short ST_SUCCESS = 0;
    /**
     * Status de retorno - Aplicação executada sem argumentos.
     */
    public static final short ERR_NO_ARGUMENTS = 1;
    /**
     * Status de retorno - Erro de IO.
     */
    public static final short ERR_IO = 2;
    /**
     * Diretório corrente.
     */
    public static final String CURRENT_DIR = ".";
    /**
     * Contra Barra.
     */
    public static final String BACKSLASH = "\\\\";
    /**
     * Barra.
     */
    public static final String SLASH = "/";

    /**
     * Construtor privado para adequação com o checkstyle.
     */
    private ContaLinhas() {
    }

    /**
     * Método de execução principal.
     * @param args Argumentos passados ao programa
     */
    public static void main(final String[] args) {
        FileAnalyzer analyzer;
        Path path;

        if (args.length == 0) {
            System.out.println("Informar ao menos 1 argumento");
            System.exit(ERR_NO_ARGUMENTS);
        } else {
            if (args.length == 1) {
                analyzer = new FileAnalyzer(args[0]);
                path = Paths.get(CURRENT_DIR);
            } else {
                args[1].replaceAll(BACKSLASH, SLASH);
                analyzer = new FileAnalyzer(args[1]);
                path = Paths.get(args[0]);
            }
            try {
                Files.walkFileTree(path, analyzer);
                ContaLinhas.print(analyzer.getLineCount());
                System.exit(ST_SUCCESS);
            } catch (IOException e) {
                System.out.println("Erro de IO");
                System.exit(ERR_IO);
            }
        }
    }
    /**
     * Imprime o resultado da contagem de linhas.
     * @param mapa Mapa com os caminhos e a contagem de suas linhas.
     */
    public static void print(final LinkedHashMap<String, Integer> mapa) {
        int total = 0;
        for (Entry<String, Integer> e : mapa.entrySet()) {
            int count = e.getValue();
            total += count;
            System.out.println(count + " " + e.getKey());
        }
        System.out.println("\nTotal de linhas: " + total);
    }
}
