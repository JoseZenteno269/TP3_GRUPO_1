package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.Producto;

public class DaoProductos {
	
	private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

public DaoProductos() {	
}

	public int agregarProducto(Producto producto) {

    	Connection cn = null;
    	int filas = 0;
    	try {
        	cn = DriverManager.getConnection(host + dbName, user, pass);
        	String query = "{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}";
        	CallableStatement cs = cn.prepareCall(query);
        	cs.setString(1, producto.getCodigo());
        	cs.setString(2, producto.getNombre());
        	cs.setFloat(3, producto.getPrecio());
        	cs.setInt(4, producto.getStock());
        	cs.setInt(5, producto.getCategoria().getIdCategoria()); 
        	filas = cs.executeUpdate();
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

	public int eliminarProducto(String codigo) {

    	Connection cn = null;
    	int filas = 0;
    	try {
        	cn = DriverManager.getConnection(host + dbName, user, pass);
        	String query = "DELETE FROM Productos WHERE Codigo = ?";
        	PreparedStatement pst = cn.prepareStatement(query);
        	pst.setString(1, codigo);
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
