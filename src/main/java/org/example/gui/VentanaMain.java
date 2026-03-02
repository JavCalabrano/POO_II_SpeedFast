package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMain extends JFrame {
    private JButton btnRepartidores;
    private JPanel panelPrincipal;
    private JButton btnPedido;
    private JButton btnEngregas;


    public VentanaMain() {

    // Configuracion de tabla
    setContentPane(panelPrincipal);
    setTitle("Menu principal SpeddFast");
    setSize(300, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);


    btnRepartidores.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            GUIRepartidor vRepartidor = new GUIRepartidor();
            vRepartidor.setVisible(true);
        }
    });
        btnPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIPedido vPedido = new GUIPedido();
                vPedido.setVisible(true);
            }
        });
        btnEngregas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIEntregas vEntrega = new GUIEntregas();
                vEntrega.setVisible(true);
            }
        });
    }



}



