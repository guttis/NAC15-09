package gustavogalesi.com.br.modelo;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class cep {

    @SerializedName(value = "cep")
    private String cep;
    @SerializedName(value = "logradouro")
    private String logradouro;
    @SerializedName(value = "bairro")
    private  String bairro;
    @SerializedName(value = "cidade")
    private String cidade;
    @SerializedName(value = "estado")
    private String estado;

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {this.estado = estado;}
}
