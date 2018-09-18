package com.github.jprnp.aplicacao;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Classe principal da aplicação para contar quantidade de Instituições por UF.
 * @author jprnp
 */
public final class Aplicacao {
  /**
   * Construtor privado p/ atender ao checkstyle.
   */
  private Aplicacao() { }

  /**
   * Código de erro - Arquivo não encontrado.
   */
  public static final int ERR_NOT_FOUND = 4;
  /**
   * Quantidade de linhas a serem ignoradas do arquivo.
   */
  public static final short LINES_TO_IGNORE = 11;
  /**
   * Índice em que o código da UF se encontra.
   */
  public static final short UF_INDEX = 7;
  /**
   * Índice em que a descrição da UF se encontra.
   */
  public static final short DESC_INDEX = 8;
  /**
   * Url a ser acessada.
   */
  private static String urlCsv;
  /**
   * Status de retorno do programa.
   */
  private static int status = 0;
  /**
   * Leitor de arquivos.
   */
  private static Scanner scan;
  /**
   * HashTable com os valores.
   */
  private static Hashtable<Integer, Integer> dataTable =
      new Hashtable<Integer, Integer>();
  /**
   * Hashtable com as descrições das UFs.
   */
  private static Hashtable<Integer, String> estados =
      new Hashtable<Integer, String>();
  /**
   * ArrayList com os valores ordenados.
   */
  private static ArrayList<Map.Entry<Integer, Integer>> list;

  /**
   * Execução principal do programa.
   * @param args = array de argumentos passados ao programa
   */
  public static void main(final   String[] args) {
    if (args.length > 0) {
      setUrlCsv(args[0]); // Apenas o primeiro argumento será considerado
    } else {
      setUrlCsv("http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES"
          + "_2011.csv");
    }

    getFile();
    countOccurrences();
    sortTable();
    printTable();
    System.exit(getStatus());
  }

  /**
   * Fazer download do arquivo da web.
   */
  public static void getFile() {
    try {
      URL url = new URL(getUrlCsv());
      Locale loc = Locale.getDefault();
      scan = new Scanner(url.openStream(), "utf-8");
      scan.useLocale(loc);
    } catch (IOException ex) {
      ex.printStackTrace();
      setStatus(ERR_NOT_FOUND);
      System.exit(getStatus());
    }
  }

  /**
   * Contar ocorrências de instituições de ensino para cada estado.
   */
  public static void countOccurrences() {
    String line;
    String descricao;
    int uf;

    for (int i = 0; i < LINES_TO_IGNORE; i++) {
      if (scan.hasNextLine()) {
        line = scan.nextLine();
      }
    }

    while (scan.hasNextLine()) {
      line = scan.nextLine();
      String[] values = line.split(";");

      try {
        uf = Integer.parseInt(values[UF_INDEX]);
      } catch (NumberFormatException e) {
        continue;
      } catch (ArrayIndexOutOfBoundsException e1) {
        break;
      }
      descricao = values[DESC_INDEX];

      if (dataTable.containsKey(uf)) {
        // dataTable.put(uf, dataTable.get(uf) + 1);
        dataTable.replace(uf, (dataTable.get(uf) + 1));
      } else {
        dataTable.put(uf, 1);
        estados.put(uf, descricao);
      }
    }
  }

  /**
   * Ordenar os dados de forma decrescente.
   */
  public static void sortTable() {
    list = new ArrayList<Map.Entry<Integer, Integer>>(dataTable.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<?, Integer>>() {

      @Override
      public int compare(final Entry<?, Integer> o1,
          final Entry<?, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });
  }

  /**
   * Imprimir resultados na tela.
   */
  public static void printTable() {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(
          "UF: " + estados.get(list.get(i).getKey()) + "\t - \tQtd: "
              + list.get(i).getValue());
    }
  }

  /**
   * Getter de urlCsv.
   * @return the urlCsv
   */
  private static String getUrlCsv() {
    return urlCsv;
  }

  /**
   * Setter de urlCsv.
   * @param url the url to set
   */
  private static void setUrlCsv(final String url) {
    Aplicacao.urlCsv = url;
  }

  /**
   * Getter de status.
   * @return the status
   */
  private static int getStatus() {
    return status;
  }

  /**
   * Setter de status.
   * @param st the status to set
   */
  private static void setStatus(final int st) {
    Aplicacao.status = st;
  }
}
