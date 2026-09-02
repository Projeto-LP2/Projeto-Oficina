package com.github.projetolp2.controller;

import com.github.projetolp2.model.Veiculo;
import com.github.projetolp2.repository.IPersistencia;
import com.github.projetolp2.repository.VeiculoRepository;

import java.util.List;

public class VeiculoController {
    //Tudo relacionado a validação deve passar por ele
    //Interface envia -> Esse valida -> repository salva -> banco

    private final IPersistencia<Veiculo> repository;

    public VeiculoController () {
        this.repository = new VeiculoRepository();
    }

    //Verificaçao para cadstro
    public ResultadoOperacao cadastrar(Veiculo veiculo) {

        if (veiculo.getPlaca() == null || veiculo.getPlaca().isBlank()) {
            return new ResultadoOperacao(false, "Placa é obrigatória.");
        }
        if (veiculo.getPlaca().length() > 10) {
            return new ResultadoOperacao(false, "Placa deve ter no máximo 10 caracteres.");
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().isBlank()) {
            return new ResultadoOperacao(false, "Modelo é obrigatório.");
        }
        if (veiculo.getModelo().length() > 50) {
            return new ResultadoOperacao(false, "Modelo deve ter no máximo 50 caracteres.");
        }

        if (veiculo.getMarca() == null || veiculo.getMarca().isBlank()) {
            return new ResultadoOperacao(false, "Marca é obrigatória.");
        }
        if (veiculo.getMarca().length() > 50) {
            return new ResultadoOperacao(false, "Marca deve ter no máximo 50 caracteres.");
        }

        if (veiculo.getAno() < 1950 || veiculo.getAno() > 2027) {
            return new ResultadoOperacao(false, "Ano inválido.");
        }

        if (veiculo.getProprietario() == null || veiculo.getProprietario().isBlank()) {
            return new ResultadoOperacao(false, "Proprietário é obrigatório.");
        }
        if (veiculo.getProprietario().length() > 100) {
            return new ResultadoOperacao(false, "Proprietário deve ter no máximo 100 caracteres.");
        }

        if (veiculo.getTelefoneProprietario() == null || veiculo.getTelefoneProprietario().isBlank()) {
            return new ResultadoOperacao(false, "Telefone é obrigatório.");
        }
        //Verifica se é número de 0 até 9, se tem "-" ou se tem "+"
        if (!veiculo.getTelefoneProprietario().matches("[0-9()\\-\\s+]+")) {
            return new ResultadoOperacao(false, "Telefone deve conter apenas números e símbolos válidos.");
        }

        boolean sucesso = repository.adicionar(veiculo);
        //Se sucesso for true, cria um resultado positivo, do contrario cria um avisando o erro.
        return sucesso
                ? new ResultadoOperacao(true, "Veículo cadastrado com sucesso.")
                : new ResultadoOperacao(false, "Erro ao salvar no banco.");
    }

    //Verificação para consulta
    public List<Veiculo> consultar(String termo, String criterio) {
        return repository.consultar(termo, criterio);
    }

    //Verificação para edição
    public ResultadoOperacao editar(Veiculo veiculo) {
        boolean sucesso = repository.alterar(veiculo);

        return sucesso
                ? new ResultadoOperacao(true, "Veículo editado com sucesso.")
                : new ResultadoOperacao(false, "Erro ao salvar no banco.");
    }

    //Verificação para exclusão
    public ResultadoOperacao excluir(int codigo) {
        boolean sucesso = repository.excluir(codigo);

        return sucesso
                ? new ResultadoOperacao(true, "Veiculo excluído com sucesso.")
                : new ResultadoOperacao(false, "Erro ao excluir veículo");
    }


}
