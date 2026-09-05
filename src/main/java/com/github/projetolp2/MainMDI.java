package com.github.projetolp2;

import com.github.projetolp2.util.DatabaseSetup;
import com.github.projetolp2.view.mdi.TelaPrincipalMDI;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Guerreiro 3.0
 */
public class MainMDI {

    public static void main(String[] args) {
        DatabaseSetup.criarTabela();
        
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalMDI tela = new TelaPrincipalMDI();
            tela.setVisible(true);
        });
    }
}
