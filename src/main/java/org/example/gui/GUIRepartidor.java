package org.example.gui;

import org.example.dao.Conexion;
import org.example.dao.RepartidorDAO;
import org.example.model.Repartidor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GUIRepartidor extends JFrame {
    private JButton btnAddRepartidor;
    private JButton btnActualizarRepartidor;
    private JButton btnEliminarRepartidor;
    private JPanel panelRepartidor;
    private JTextField txtRepartidorNombre;
    private JTable tblRepartidores;
    private JTextField txtID;
    private DefaultTableModel modelRepartidor;

    public GUIRepartidor() {

    // Configuracion de GUI
    setContentPane(panelRepartidor);
    setTitle("Gestión Repartidores");
    setSize(400, 300);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    // Configuracion tabla
    String[] columnas = {"ID", "Nombre"};
    modelRepartidor = new DefaultTableModel(columnas, 0);
    tblRepartidores.setModel(modelRepartidor);

    cargarTabla();


        btnAddRepartidor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!validarNombre()) {
                    return;
                }

                String nombre = txtRepartidorNombre.getText().trim();
                Repartidor rep = new Repartidor(nombre);

                // Paso que escribe el repatidor en BD
                RepartidorDAO addRep =  new RepartidorDAO();

                try {
                    addRep.agregarRep(rep);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                cargarTabla();
            }
        });

        btnEliminarRepartidor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!validarID()) {
                    return;
                }
                String txtId = txtID.getText().trim();
                int id = 0;
                try {
                    id = Integer.parseInt(txtId);
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar el ID");
                }

                Repartidor rep = new Repartidor(id);

                RepartidorDAO eliminarRep =  new RepartidorDAO();

                try {
                    eliminarRep.eliminarRep(rep);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        btnActualizarRepartidor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void cargarTabla() {
        modelRepartidor.setRowCount(0);
        try {
            List<Repartidor> lista = RepartidorDAO.readAll();
            for (Repartidor r : lista) {
                modelRepartidor.addRow(new Object[]{r.getId(), r.getNombre()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar repartidores: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private boolean validarNombre() {
        String nombre = txtRepartidorNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;

    }

    private boolean validarID() {
        String txtId = txtID.getText().trim();

        if (txtId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El id es obligatorio.",
                    "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;

    }




}
