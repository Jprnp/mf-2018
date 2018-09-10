package br.ufg.inf.mf.pratica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Nome {
  public static void main( String args[] ) {
    Locale lcl = Locale.getDefault();
    LocalDate lclDate = LocalDate.now();
    String dia = lclDate.format(DateTimeFormatter.ofPattern("EEEE", lcl));
    System.out.println(dia);
  }
}
