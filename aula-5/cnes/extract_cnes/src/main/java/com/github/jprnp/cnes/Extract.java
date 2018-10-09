package com.github.jprnp.cnes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
   * Ponto e vírgula.
   */
  public static final String SEMICOLON = ";";
  /**
   * Posição da coluna código no csv.
   */
  public static final short CODIGO = 0;
  /**
   * Posição da coluna razão social no csv.
   */
  public static final short RAZAO = 5;
  /**
   * Posição da coluna latitude no csv.
   */
  public static final short LATITUDE = 39;
  /**
   * Posição da coluna longitude no csv.
   */
  public static final short LONGITUDE = 40;
  /**
   * Leitor do arquivo.
   */
  public static BufferedReader rd = null;
  /**
   * Lista de unidades médicas.
   */
  public static ArrayList<UnidadeMedica> unidades = null;

  /**
   * Método principal de execução.
   * @param args argumentos do programa
   */
  public static void main(final String[] args) {
    URL cnesUrl = null;
    URLConnection con = null;
    ZipInputStream zipStream = null;
    ZipEntry entry = null;
    
    if (args.length < 2) {
      System.out.println("Informar 2 argumentos.");
      System.exit(3);
    }

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
        rd = new BufferedReader(
            new InputStreamReader(zipFile.getInputStream(entry)));
        processaArquivo();
        rd.close();
        break;
      }
      file.deleteOnExit();
      zipFile.close();
      gerarArquivo(args[1]);
      System.out.println("Arquivo " + args[1] + " gerado com sucesso!");
      System.exit(0);
    } catch (IOException e) {
      System.out.println("Exceção de IO.");
      System.exit(2);
    }
  }
  
  /**
   * Leitura das linhas do arquivo .csv e preenchimento da lista com os atributos
   * pertinentes por unidade médica.
   * @throws IOException Exceção de IO
   */
  private static void processaArquivo() throws IOException {
    String line = null;
    String[] split = null;
    line = rd.readLine();
    while ((line = rd.readLine()) != null) {
      split = line.split(SEMICOLON);
      unidades.add(new UnidadeMedica(split[CODIGO], split[RAZAO],
          split[LATITUDE], split[LONGITUDE]));
    }
  }
  
  private static void gerarArquivo(final String name) throws IOException {
    FileWriter writer = new FileWriter("./" + name);
    Gson gson = new Gson();
    gson.toJson(unidades, writer);
  }
}
