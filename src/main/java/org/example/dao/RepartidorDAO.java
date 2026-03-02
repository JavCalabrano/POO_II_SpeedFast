package org.example.dao;

import org.example.model.Repartidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public void agregarRep(Repartidor r) throws SQLException {
        String sql = "INSERT INTO repartidores(nombre) VALUES(?)";
        try (Connection cx = Conexion.obtenerConexion();
             PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, r.getId());
            statement.executeUpdate();
        }
    }

    public void eliminarRep(Repartidor r) throws SQLException {

        String sql = "DELETE FROM repartidores WHERE id=?";
        try (Connection cx = Conexion.obtenerConexion();
        PreparedStatement statement = cx.prepareStatement(sql)) {
            statement.setInt(1, r.getId());
            statement.executeUpdate();
        }


    }

    public static List<Repartidor> readAll() throws SQLException {
        List<Repartidor> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM repartidores";
        try (Connection cx = Conexion.obtenerConexion();
             PreparedStatement ps = cx.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Repartidor r = new Repartidor();
                r.setId(rs.getInt("id"));
                r.setNombre(rs.getString("nombre"));
                lista.add(r);
            }
        }
        return lista;
    }
}
