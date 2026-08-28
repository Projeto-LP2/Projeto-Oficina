package com.github.projetolp2.util;

import com.github.projetolp2.repository.Conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    //Tudo que rodava no SQLscript deve ficar aqui

    public static void criarTabela() {
        //String do código que será rodado
        String sql = """
                CREATE TABLE IF NOT EXISTS veiculo (
                        codigo SERIAL PRIMARY KEY,
                        placa VARCHAR(10) NOT NULL,
                        modelo VARCHAR(50) NOT NULL,
                        marca VARCHAR(50) NOT NULL,
                        ano INT NOT NULL,
                        proprietario VARCHAR(100) NOT NULL,
                        telefone_proprietario VARCHAR(20),
                        descricao_servico VARCHAR(255)
                    )""";
        Connection con = Conexao.getConexao();
        Statement stmt = null;

        try {
            if (con == null) {
                System.err.println("Não foi possivel conectar no banco de dados para criar a tabela.");
                return;
            }

            stmt = con.createStatement();
            stmt.execute(sql);

            System.out.println("Tabela 'Veiculo' verificada/criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }

    }
}
