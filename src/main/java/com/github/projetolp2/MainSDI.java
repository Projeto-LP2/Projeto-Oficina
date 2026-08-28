/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.projetolp2;

import com.github.projetolp2.view.TelaPrincipal;
import com.github.projetolp2.view.TelaSobreSDI;

import javax.swing.SwingUtilities;
/**
 *
 * @author Guerreiro 3.0
 */
public class MainSDI 
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> 
        {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}