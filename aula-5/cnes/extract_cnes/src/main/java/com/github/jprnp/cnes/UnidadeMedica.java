package com.github.jprnp.cnes;

/**
 * Informações pertinentes por unidade médica.
 * @author jprnp
 */
public final class UnidadeMedica {
  /**
   * Código da unidade médica.
   */
  private String codigo;
  /**
   * Razão social cadastrada pela unidade médica.
   */
  private String razao;
  /**
   * Latitude onde a unidade médica está localizada.
   */
  private String latitude;
  /**
   * Longitude onde a unidade médica está localizada.
   */
  private String longitude;

  /**
   * Instancia o objeto com todos os seus atributos preenchidos.
   * @param cod O código da unidade médica
   * @param raz A razão social cadastrada pela unidade médica
   * @param lat A latitude onde a unidade médica está localizada
   * @param lon A longitude onde a unidade médica está localizada
   */
  public UnidadeMedica(final String cod, final String raz, final String lat,
      final String lon) {
    this.codigo = cod;
    this.razao = raz;
    this.latitude = lat;
    this.longitude = lon;
  }

  /**
   * Getter de codigo.
   * @return the codigo
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * Setter de codigo.
   * @param codigo the codigo to set
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  /**
   * Getter de razao.
   * @return the razao
   */
  public String getRazao() {
    return razao;
  }

  /**
   * Setter de razao.
   * @param razao the razao to set
   */
  public void setRazao(String razao) {
    this.razao = razao;
  }

  /**
   * Getter de latitude.
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Setter de latitude.
   * @param latitude the latitude to set
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Getter de longitude.
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Setter de longitude.
   * @param longitude the longitude to set
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}
