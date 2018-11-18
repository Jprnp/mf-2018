package br.ufg.inf.jprnp.dto;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;

@XmlRootElement
public class CadastroDto {
    // Identificador
    @XmlElement
    private String idIdentificador;
    @XmlElement
    private String individuo;
    @XmlElement
    private String designacao;
    @XmlElement
    private int area;
    @XmlElement
    private String alternativo;
    @XmlElement
    private String descricaoArea;
    @XmlElement
    private String emissor;
    @XmlElement
    private String data;
    @XmlElement
    private String tipoIdentificador;
    @XmlElement
    private String descricaoTipoId;

    // Certidao
    @XmlElement
    private int tipoCertidao;
    @XmlElement
    private String descricaoTipoCert;
    @XmlElement
    private String cartorio;
    @XmlElement
    private int livro;
    @XmlElement
    private int folha;
    @XmlElement
    private int termo;

    // Titulo
    @XmlElement
    private int zona;
    @XmlElement
    private int sessao;

    // Vinculo
    @XmlElement
    private int relacionamento;
    @XmlElement
    private String descricaoRelacionamento;
    @XmlElement
    private String dataInVinculo;
    @XmlElement
    private String dataFinVinculo;

    // Utilizacao
    @XmlElement
    private String nome;
    @XmlElement
    private String utilizacao;
    @XmlElement
    private String alternativaUtilizacao;
    @XmlElement
    private String titulos;
    @XmlElement
    private String nomes;
    @XmlElement
    private String sobrenomes;
    @XmlElement
    private String sufixos;
    @XmlElement
    private int preferido;
    @XmlElement
    private String descricaoPreferido;
    @XmlElement
    private int usoCondicional;
    @XmlElement
    private String descricaoUsoCondicional;
    @XmlElement
    private int uso;
    @XmlElement
    private String alternativoUso;
    @XmlElement
    private String descricaoUso;
    @XmlElement
    private String dataInUtilizacao;
    @XmlElement
    private String dataFinUtilizacao;

    // CTPS
    @XmlElement
    private int serie;
    @XmlElement
    private String estado;
    @XmlElement
    private String nomeEstado;

    // Comunicacao
    @XmlElement
    private int meio;
    @XmlElement
    private String descicaoMeio;
    @XmlElement
    private String alternativoMeio;
    @XmlElement
    private String preferencia;
    @XmlElement
    private String descricaoPreferencia;
    @XmlElement
    private String detalhe;
    @XmlElement
    private int usoComunicacao;
    @XmlElement
    private String descricaoUsoComunicacao;
    @XmlElement
    private String alternativoUsoComunicacao;

    //Endereco
    @XmlElement
    private String endereco;
    @XmlElement
    private String bairro;
    @XmlElement
    private String distrito;
    @XmlElement
    private int municipio;
    @XmlElement
    private String descricaoMunicipio;
    @XmlElement
    private String cep;
    @XmlElement
    private String caixaPostal;
    @XmlElement
    private int pais;
    @XmlElement
    private String nomePais;
    @XmlElement
    private int tipoEndereco;
    @XmlElement
    private String descricaoTipoEnd;
    @XmlElement
    private String dataInicialEnd;
    @XmlElement
    private String dataInEndAcu;
    @XmlElement
    private String dataFinalEnd;
    @XmlElement
    private String dataFinEndAcu;
    @XmlElement
    private String linhaEndereco;
    @XmlElement
    private int ordemEndereco;

    // Dado Demografico
    @XmlElement
    private String nascimento;
    @XmlElement
    private String nascAcuracia;
    @XmlElement
    private String nascSeguimento;
    @XmlElement
    private String descricaoNascSeg;
    @XmlElement
    private int nascPluralidade;
    @XmlElement
    private String descricaoNascPlu;
    @XmlElement
    private int nascOrdem;
    @XmlElement
    private String descricaoNascOrd;
    @XmlElement
    private String obito;
    @XmlElement
    private String obitoAcuracia;
    @XmlElement
    private int obitoFonte;
    @XmlElement
    private String descricaoObitoFnt;
    @XmlElement
    private int sexo;
    @XmlElement
    private String descricaoSexo;
    @XmlElement
    private String alternativoSexo;
    @XmlElement
    private String mae;
    @XmlElement
    private String pai;
    @XmlElement
    private int situacaoFamiliar;
    @XmlElement
    private String descricaoSitFam;
    @XmlElement
    private int raca;
    @XmlElement
    private String descricaoRaca;
    @XmlElement
    private String comentario;
    @XmlElement
    private int nacionalidade;
    @XmlElement
    private String descricaoNacionalidade;
    @XmlElement
    private String dataEntradaPais;

    protected static CadastroDto fromJson(String json, Class<?> src) {
        Gson gson = new Gson();
        return gson.fromJson(json, (Type) src);
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    protected static CadastroDto fromXml(String xml, Class<?> src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(src);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader rd = new StringReader(xml);
        return (CadastroDto) unmarshaller.unmarshal(rd);
    }

    public String toXml() throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        Writer sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }
}
