package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public int modificarCategoria(Categorias categoria) {

        Connection cn = null;

        int filas = 0;

        try {

            cn = DriverManager.getConnection(host + dbName, user, pass);

            String query = "UPDATE Categorias SET Nombre = ? WHERE IdCategoria = ?";

            PreparedStatement pst = cn.prepareStatement(query);

            pst.setString(1, categoria.getNombre());
            pst.setInt(2, categoria.getIdCategoria());

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
    
    public ArrayList<Categorias> listarCategorias() {

        Connection cn = null;

        ArrayList<Categorias> lista = new ArrayList<Categorias>();

        try {

            cn = DriverManager.getConnection(host + dbName, user, pass);

            String query = "SELECT IdCategoria, Nombre FROM Categorias";

            PreparedStatement pst = cn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Categorias categoria = new Categorias();

                categoria.setIdCategoria(rs.getInt("IdCategoria"));
                categoria.setNombre(rs.getString("Nombre"));
                lista.add(categoria);
            }
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
        return lista;
    }
    
    
}
