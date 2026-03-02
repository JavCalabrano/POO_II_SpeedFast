package org.example.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUIEntregas extends JFrame {


    private JPanel panelEntregas;
    private JButton btnRegistrar;
    private JTable tblEntregas;
    private JButton btnActualizarENtrega;
    private JButton btnEliminarEntrega;
    private DefaultTableModel modeloEntrega;


    public GUIEntregas() {

    // Configuracion de panel
    setContentPane(panelEntregas);
    setTitle("Gestión de entregas");
    setSize(500, 500);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    // Configuracion tabla
    String[] columnas = {"ID", "Nombre"};
    modeloEntrega = new DefaultTableModel(columnas, 0);
    tblEntregas.setModel(modeloEntrega);





}




}
