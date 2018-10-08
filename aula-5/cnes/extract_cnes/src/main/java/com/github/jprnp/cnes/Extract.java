package com.github.jprnp.cnes;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Classe principal de execução.
 * @author jprnp
 */
public final class Extract {
  /**
   * Nome do arquivo a ser tratado.
   */
  public static final String FILENAME = "tbEstabelecimento";
  /**
   * Leitor do arquivo.
   */
  public static InputStreamReader rd = null;

  /**
   * Método principal de execução.
   * @param args argumentos do programa
   */
  public static void main(final String[] args) {
    URL cnesUrl = null;
    URLConnection con = null;
    ZipInputStream zipStream = null;
    ZipEntry entry = null;

    try {
      cnesUrl = new URL(args[0]);
    } catch (MalformedURLException e) {
      System.out.println("URL informada nao e valida!");
      System.exit(1);
    }

    try {
      con = cnesUrl.openConnection();
    } catch (IOException e) {
      System.out.println("Exceção de IO.");
      System.exit(2);
    }

    try {
      zipStream = new ZipInputStream(con.getInputStream());
      File file = File.createTempFile("cnes", ".zip");
      ZipFile zipFile = new ZipFile(file);
      while ((entry = zipStream.getNextEntry()) != null) {
        if (!entry.getName().contains(FILENAME)) {
          continue;
        }
        rd = new InputStreamReader(zipFile.getInputStream(entry));  
        processaArquivo();
        rd.close();
        break;
      }
      zipFile.close();
      //int data = rd.read();
      System.out.println(rd.read());
    } catch (IOException e) {
      System.out.println("Exceção de IO.");
      System.exit(2);
    }
  }
  
  public static void processaArquivo() {
    
  }
}
