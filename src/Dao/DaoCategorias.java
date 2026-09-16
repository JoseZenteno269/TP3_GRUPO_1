package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidades.Categorias;

public class DaoCategorias {

    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

    public DaoCategorias() {
    }

    public int agregarCategoria(Categorias categoria) {
        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            String query = "INSERT INTO Categorias (Nombre) VALUES (?)";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, categoria.getNombre());
            filas = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return filas;
    }

    public int eliminarCategoria(int idCategoria) {
        Connection cn = null;
        int filas = 0;

        try {
            cn = DriverManager.getConnection(host + dbName, user, pass);
            String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, idCategoria);
            filas = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return filas;
    }
}
