package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Categorias;

public class DaoCategorias {
	
	Datos datos = new Datos(); 
	
	// Agregar
    public Boolean agregarCategoria(Categorias categoria) {
    	Connection cn = null; 
        int filas = 0;

        try {
            cn = datos.obtenerConexion(); 
            String query = "INSERT INTO Categorias (Nombre) VALUES (?)";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, categoria.getNombre());
            filas = pst.executeUpdate();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return filas != 0;
    }

    // Eliminacion 
    public Boolean eliminarCategoria(int idCategoria) {
        Connection cn = null;
        int filas = 0;

        try {
            cn = datos.obtenerConexion(); 
            String query = "DELETE FROM Categorias WHERE IdCategoria = ?";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, idCategoria);
            filas = pst.executeUpdate();
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filas != 0;
    }
    
    // modificacion 
    public Boolean modificarCategoria(Categorias categoria) {

        Connection cn = null;
        int filas = 0;

        try {
            cn = datos.obtenerConexion();

            String query = "UPDATE Categorias SET Nombre = ? WHERE IdCategoria = ?";
            PreparedStatement pst = cn.prepareStatement(query);

            pst.setString(1, categoria.getNombre());
            pst.setInt(2, categoria.getIdCategoria());

            filas = pst.executeUpdate();
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filas != 0;
    }
    
    // listado 
    public ArrayList<Categorias> listarCategorias() {

        Connection cn = null;

        ArrayList<Categorias> lista = new ArrayList<Categorias>();

        try {

            cn = datos.obtenerConexion(); 

            String query = "SELECT IdCategoria, Nombre FROM Categorias";

            PreparedStatement pst = cn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Categorias categoria = new Categorias();

                categoria.setIdCategoria(rs.getInt("IdCategoria"));
                categoria.setNombre(rs.getString("Nombre"));
                lista.add(categoria);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
    
    
}
