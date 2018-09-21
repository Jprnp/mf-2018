package com.github.jprnp.conta_linhas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;

/**
 * Analisador de arquivos.
 * @author jprnp João Pedro Pinheiro
 */
public final class FileAnalyzer extends SimpleFileVisitor<Path> {
    /**
     * Contagem de linhas dos arquivos analisados.
     */
    private LinkedHashMap<String,
            Integer> lineCount = new LinkedHashMap<String, Integer>();
    /**
     * Sufixo que define quais arquivos deverão ser analisados.
     */
    private String sufix;

    /**
     * Construtor que inicializa o sufixo.
     * @param suf O sufixo a ser setado
     */
    public FileAnalyzer(final String suf) {
        this.sufix = suf;
    }

    @Override
    public FileVisitResult visitFile(final Path path,
            final BasicFileAttributes attributes) {
        FileReader fr;
        LineNumberReader lnr;
        int count = 0;

        if (!path.toString().endsWith(this.sufix)) {
            return FileVisitResult.CONTINUE;
        }

        try {
            fr = new FileReader(path.toString());
            lnr = new LineNumberReader(fr);

            while (lnr.readLine() != null) {
                count += 1;
            }
            lnr.close();
            lineCount.put(path.toAbsolutePath().toString(), count);
        } catch (FileNotFoundException e) {
            return FileVisitResult.TERMINATE;
        } catch (IOException e) {
            return FileVisitResult.TERMINATE;
        }
        return FileVisitResult.CONTINUE;
    }
    /**
     * @return lineCount A contagem de linhas por arquivo
     */
    public LinkedHashMap<String, Integer> getLineCount() {
        return this.lineCount;
    }
}
