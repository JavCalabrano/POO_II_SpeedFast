package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection obtenerConexion(){

        Connection conexion = null;
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/speedfast_db", "root", "Mansedumbr3270414.");
            System.out.println("Conexion establecida!");
        } catch (SQLException e) {
            System.out.println("Error de conexion " + e.getMessage() );
        } catch ( Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;

    };

}
