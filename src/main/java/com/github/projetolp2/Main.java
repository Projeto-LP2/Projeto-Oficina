package com.github.projetolp2;

import com.github.projetolp2.model.Veiculo;
import com.github.projetolp2.repository.Conexao;
import com.github.projetolp2.repository.VeiculoRepository;
import com.github.projetolp2.util.DatabaseSetup;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //Iniciando a tabela
        DatabaseSetup.criarTabela();

        //Iniciando conexão com o banco
        Connection con = Conexao.getConexao();

        if (con != null) {
            System.out.println("Conectado com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }

        Veiculo veiculo = new Veiculo(123, "123", "123", "123", 1234, "123", "123" , "123");
        VeiculoRepository repositorio = new VeiculoRepository();
        repositorio.adicionar(veiculo);

        //Fechando conexão
        Conexao.fecharConexao(con, (Statement) null);

    }
}