package com.github.projetolp2.model;

public class Veiculo {
    private int codigo;
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private String proprietario;
    private String telefoneProprietario;
    private String descricaoServico;


    public Veiculo(int codigo, String placa, String modelo, String marca, int ano, String proprietario, String telefoneProprietario, String descricaoServico) {
        this.codigo = codigo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.proprietario = proprietario;
        this.telefoneProprietario = telefoneProprietario;
        this.descricaoServico = descricaoServico;
    }
    
    public Veiculo() {
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return this.codigo;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getPlaca() {
        return this.placa;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo() {
        return this.modelo;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }


    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getAno() {
        return ano;
    }


    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public String getProprietario() {
        return proprietario;
    }


    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }
    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }


    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }
    public String getDescricaoServico() {
        return descricaoServico;
    }
}
