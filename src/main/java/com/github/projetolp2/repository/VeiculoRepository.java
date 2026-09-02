package com.github.projetolp2.repository;

import com.github.projetolp2.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements IPersistencia<Veiculo> {
    //Serve como nosso antigo VeiculoDAO

    @Override
    public boolean adicionar(Veiculo objeto) {
        //Criando conexão
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        //Código sql
        String sql = "INSERT INTO veiculo (placa, modelo, marca, ano, proprietario, telefone_proprietario, descricao_servico) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        //Seta os valores no Statement pre compilado
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
            //Independente do que ocorrer fechamos a conexão
            Conexao.fecharConexao(con, stmt);
        }
    }

    @Override
    public List<Veiculo> consultar(String termo, String criterio) {
        List<Veiculo> veiculos = new ArrayList<>();
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql;
        boolean buscaPorCodigo = criterio.equals("codigo");

        //Criterio se é placa, modelo e proprietario
        switch (criterio) {
            case "placa":
            case "modelo":
            case "proprietario":
                sql = "SELECT * FROM veiculo WHERE " + criterio + " ILIKE ?";
                break;
            case "codigo":
                sql = "SELECT * FROM veiculo WHERE codigo = ?";
                break;
            case "todos":
                sql = "SELECT * FROM veiculo ORDER BY codigo";
                break;
            default:
                throw new IllegalArgumentException("Critério de busca inválido: " + criterio);
        }

        try {
            stmt = con.prepareStatement(sql);

            //Verificando se é pra buscar por codigo
            if (buscaPorCodigo) {
                stmt.setInt(1, Integer.parseInt(termo.trim()));
            } else if (!criterio.equals("todos")){
                //Se tiver vazio foi pq não digitou nada
                if(termo.isBlank()) {
                    //Para a execução do try e ja vai retornar a lista vazia
                    //A lista vazia vai ser pego no front e vai mostrar o "erro"
                    throw new IllegalArgumentException();
                }
                stmt.setString(1, "%" + termo + "%");
            }

            rs = stmt.executeQuery();

            //Enquanto a query estiver enviando restas ele vai criando objetos Veiculos
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("codigo"),
                        rs.getString("placa"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getString("proprietario"),
                        rs.getString("telefone_proprietario"),
                        rs.getString("descricao_servico")
                );
                veiculos.add(veiculo);
            }
        } catch (NumberFormatException e) {
            System.err.println("Código inválido: " + termo);
        } catch (IllegalArgumentException e) {
            System.err.println("O termo esta vazio.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            Conexao.fecharConexao(con, stmt);
        }

        return veiculos;
    }

    @Override
    public boolean alterar(Veiculo objeto) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        String sql = """
             UPDATE veiculo 
             SET placa = ?, 
                 modelo = ?, 
                 marca = ?, 
                 ano = ?, 
                 proprietario = ?, 
                 telefone_proprietario = ?, 
                 descricao_servico = ? 
             WHERE codigo = ?
             """;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setString(1, objeto.getPlaca());
            stmt.setString(2, objeto.getModelo());
            stmt.setString(3, objeto.getMarca());
            stmt.setInt(4, objeto.getAno());
            stmt.setString(5, objeto.getProprietario());
            stmt.setString(6, objeto.getTelefoneProprietario());
            stmt.setString(7, objeto.getDescricaoServico());
            stmt.setInt(8, objeto.getCodigo());

            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Veículo de código " + objeto.getCodigo() + " alterado com sucesso");

            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao alterar informação no banco de dados");

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    @Override
    public boolean excluir(int codigo) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM veiculo WHERE codigo = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);

            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Veículo de código " + codigo + " excluído com sucesso");

            return linhasAfetadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao excluir veículo do banco de dados");

        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
