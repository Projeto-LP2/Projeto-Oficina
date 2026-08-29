package com.github.projetolp2.controller;

public class ResultadoOperacao {
    private final boolean sucesso;
    private final String mensagem;

    public ResultadoOperacao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() { return sucesso; }
    public String getMensagem() { return mensagem; }
}