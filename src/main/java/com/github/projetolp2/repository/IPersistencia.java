package com.github.projetolp2.repository;

import java.util.List;

public interface IPersistencia<T> {
    
    boolean adicionar(T objeto);

    List<T> consultar(String termo, String criterio);
    
    boolean alterar(T objeto);
    
    boolean excluir(int codigo);

}