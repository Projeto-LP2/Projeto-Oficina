package com.github.projetolp2.repository;

import com.github.projetolp2.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VeiculoRepository implements IPersistencia<Veiculo> {
    //Serve como nosso antigo VeiculoDAO

    @Override
    public boolean adicionar(Veiculo objeto) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO veiculo (placa, modelo, marca, ano, proprietario, telefone_proprietario, descricao_servico) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, objeto.getPlaca());
            stmt.setString(2, objeto.getModelo());
            stmt.setString(3, objeto.getMarca());
            stmt.setInt(4, objeto.getAno());
            stmt.setString(5, objeto.getProprietario());
            stmt.setString(6, objeto.getTelefoneProprietario());
            stmt.setString(7, objeto.getDescricaoServico());

            stmt.executeUpdate();

            System.out.println("Veículo de placa " + objeto.getPlaca() + " inserido com sucesso");

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir informação no banco de dados");

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    @Override
    public List<Veiculo> consultar(String termo) {
        return List.of();
    }

    @Override
    public boolean alterar(Veiculo objeto) {
        return false;
    }

    @Override
    public boolean excluir(int codigo) {
        return false;
    }
}
