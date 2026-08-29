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

        if (veiculo.getAno() < 1950 || veiculo.getAno() > 2027) {
            return new ResultadoOperacao(false, "Ano inválido.");
        }

        if (veiculo.getDescricaoServico().length() > 255) {
            return new ResultadoOperacao(false, "Descrição muito longa.");
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
