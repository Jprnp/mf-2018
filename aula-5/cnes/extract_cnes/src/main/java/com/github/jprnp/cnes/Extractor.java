package com.github.jprnp.cnes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Classe utilitária para download e manuseio do arquivo zip e seus csvs.
 * @author jprnp João Pedro Pinheiro
 */
public final class Extractor {
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
  public static ArrayList<
      UnidadeMedica> unidades = new ArrayList<UnidadeMedica>();

  /**
   * Faz o download de um arquivo como file temporário.
   * @param url A url de onde o arquivo será baixado
   * @return O arquivo baixado
   * @throws IOException Erro na leitura/escrita do arquivo
   */
  public static File downloadArquivo(final String url) throws IOException {
    URL cnesUrl = new URL(url);
    URLConnection con = cnesUrl.openConnection();
    con.connect();
    File file = File.createTempFile("cnes", ".zip");
    file.deleteOnExit();
    Files.copy(con.getInputStream(), file.toPath(),
        StandardCopyOption.REPLACE_EXISTING);

    return file;
  }

  /**
   * Realiza a leitura do arquivo zip em busca do csv, preenchendo a lista de
   * unidades.
   * @param file Arquivo a ser processado
   * @throws ZipException Arquivo zip inválido
   * @throws IOException  Erro na leitura/escrita do arquivo
   */
  public static void processaArquivo(final File file)
      throws ZipException, IOException {
    ZipEntry entry = null;
    ZipFile zipFile = new ZipFile(file);
    ZipInputStream zipStream = new ZipInputStream(new FileInputStream(file));
    while ((entry = zipStream.getNextEntry()) != null) {
      if (!entry.getName().contains(FILENAME)) {
        continue;
      }
      rd = new BufferedReader(
          new InputStreamReader(zipFile.getInputStream(entry)));
      preencheUnidades();
      rd.close();
      zipFile.close();
      break;
    }
    zipStream.close();
  }

  /**
   * Leitura das linhas do arquivo .csv e preenchimento da lista com os
   * atributos pertinentes por unidade médica.
   * @throws IOException Exceção de IO
   */
  private static void preencheUnidades() throws IOException {
    String line = null;
    String[] split = null;
    line = rd.readLine();
    while ((line = rd.readLine()) != null) {
      split = line.split(SEMICOLON);
      unidades.add(new UnidadeMedica(
          split[CODIGO].replace("\"", ""),
          split[RAZAO].replace("\"", ""),
          split[LATITUDE].replace("\"", ""),
          split[LONGITUDE].replace("\"", "")));
    }
  }

  /**
   * Gera um arquivo .json com as unidades processadas.
   * @param name Nome do arquivo a ser gerado
   * @throws IOException Erro na escrita do arquivo
   */
  public static void gerarArquivo(final String name) throws IOException {
    FileWriter writer = new FileWriter("./" + name);
    Gson gson = new Gson();
    gson.toJson(unidades, writer);
    writer.close();
  }
}
