package br.com.d1systems.shoppingzo.models;

import static br.com.d1systems.shoppingzo.utils.globals.decodeB64;

import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Notice {

    @SerializedName("CODIGO")
    public int Codigo;
    @SerializedName("TIPO")
    public int Tipo;
    @SerializedName("TEXTO")
    public String Texto;

    public Notice(){}



    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public String getTexto() throws UnsupportedEncodingException {
        return decodeB64(Texto);
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
}

