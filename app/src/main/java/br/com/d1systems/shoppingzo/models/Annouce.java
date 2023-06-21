package br.com.d1systems.shoppingzo.models;

import com.google.gson.annotations.SerializedName;

public class Annouce {

    public Annouce(){}

    @SerializedName("CODIGO")
    public int Codigo;

    @SerializedName("LOJA")
    public String Loja;

    @SerializedName("PRODUTO")
    public int Produto;

    @SerializedName("NOME")
    public String NomeProduto;

    @SerializedName("PRECO")
    public Double PrecoProduto;

    @SerializedName("CATEGORIA")
    public int CodCategoria;

    @SerializedName("FOTO_PRINCIPAL")
    public String FotoPrincipal;

    @SerializedName("FOTO_01")
    public String Foto01;

    @SerializedName("FOTO_02")
    public String Foto02;

    @SerializedName("IS_WHATSAPP")
    public int IsWhatsapp;

    @SerializedName("CONTATO")
    public String Contato;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getLoja() {
        return Loja;
    }

    public void setLoja(String loja) {
        Loja = loja;
    }

    public int getProduto() {
        return Produto;
    }

    public void setProduto(int produto) {
        Produto = produto;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return PrecoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        PrecoProduto = precoProduto;
    }

    public int getCodCategoria() {
        return CodCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        CodCategoria = codCategoria;
    }

    public String getFotoPrincipal() {
        return FotoPrincipal;
    }

    public void setFotoPrincipal(String fotoPrincipal) {
        FotoPrincipal = fotoPrincipal;
    }

    public String getFoto01() {
        return Foto01;
    }

    public void setFoto01(String foto01) {
        Foto01 = foto01;
    }

    public String getFoto02() {
        return Foto02;
    }

    public void setFoto02(String foto02) {
        Foto02 = foto02;
    }

    public Boolean getWhatsapp() {
        return IsWhatsapp == 1;
    }

    public void setWhatsapp(int whatsapp) {
        IsWhatsapp = whatsapp;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String contato) {
        Contato = contato;
    }
}
