package com.github.projetolp2.repository;

import com.github.projetolp2.model.Veiculo;

public interface IPersistencia {
    
    boolean adicionar(Veiculo veiculo);

    //List<Veiculo> consultar(String nomeConsulta);
    
    boolean alterar(Veiculo veiculo);
    
    boolean excluir(int codigo);

}