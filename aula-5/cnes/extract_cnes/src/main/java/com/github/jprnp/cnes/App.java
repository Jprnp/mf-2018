package com.github.jprnp.cnes;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Classe principal de execução.
 * @author jprnp
 */
public final class App {
  /**
   * Método principal de execução.
   * @param args argumentos do programa
   */
  public static void main(final String[] args) {
    if (args.length < 2) {
      System.out.println("Informar 2 argumentos.");
      System.exit(3);
    }

    try {      
      System.out.println("Realizando download...");
      File file = Extractor.downloadArquivo(args[0]);
      System.out.println("Download completo! Iniciando processamento");
      Extractor.processaArquivo(file);
      Extractor.gerarArquivo(args[1]);
      System.out.println("Arquivo " + args[1] + " gerado com sucesso!");
      System.exit(0);
    } catch (MalformedURLException e) {
      System.out.println("URL informada nao e valida!");
      System.exit(1);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(2);
    } 
  }
}
