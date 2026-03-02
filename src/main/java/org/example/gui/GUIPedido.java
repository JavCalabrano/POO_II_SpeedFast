package org.example.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPedido extends JFrame {


    private JPanel panelPedido;
    private JTextField txtDireccion;
    private JComboBox cbxTipoPedido;
    private JComboBox cbxEstadoPedido;
    private JTable tblPedido;
    private JButton btnAddPedido;
    private JButton btnActualizarPedido;
    private JButton btnEliminarPedido;
    private DefaultTableModel modelPedido;


    public GUIPedido() {

        // Configuracion de tabla
        setContentPane(panelPedido);
        setTitle("Gestión Pedidos");
        setSize(600, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuracion tabla
        String[] columnas = {"ID", "Nombre"};
        modelPedido = new DefaultTableModel(columnas, 0);
        tblPedido.setModel(modelPedido);


        btnAddPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnActualizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
