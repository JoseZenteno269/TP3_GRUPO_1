package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Producto;

public class DaoProductos {
	
	private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

	public DaoProductos() {	
	}
	
    private Connection obtenerConexion() throws SQLException {
    	return DriverManager.getConnection(host + dbName, user, pass);
    }
    
    private int ejecutarProcedimientoAlmacenado(String consulta, Object[] parametros) {
    	Connection cn = null; 
    	int filas = 0; 
    	try {
    		cn = obtenerConexion(); 
    		CallableStatement cs = cn.prepareCall(consulta); 
    		
    		for(int i = 0; i < parametros.length; i++) {
    			cs.setObject(i + 1, parametros[i]);
    		}
    		
    		filas = cs.executeUpdate(); 
    	}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
    		try {
    			if(cn != null) {
    				cn.close();
    			}
    		}
    		catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	return filas; 
    }
    
    
	public Boolean agregarProducto(Producto producto) {
		Object[] parametros = {producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.getIdCategoria()}; 
		return ejecutarProcedimientoAlmacenado("{CALL sp_AgregarProducto(?, ?, ?, ?, ?)}", parametros) != 0; 
	}
	
	// Eliminacion
	public int eliminarProducto(String codigo) {

    	Connection cn = null;
    	int filas = 0;
    	try {
        	cn = obtenerConexion(); 
        	String query = "DELETE FROM Productos WHERE Codigo = ?";
        	PreparedStatement pst = cn.prepareStatement(query);
        	pst.setString(1, codigo);
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
    	return filas;
	}
	
	//Modificacion
	public int modificarProducto(Producto producto) {
		String consulta = "UPDATE Productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?"; 
		
		Connection cn = null; 
		int filas = 0; 
		
		try {
			cn = obtenerConexion(); 
			PreparedStatement pst = cn.prepareStatement(consulta); 
			
			pst.setString(1, producto.getNombre());
			pst.setFloat(2, producto.getPrecio());
			pst.setInt(3, producto.getStock());
			pst.setInt(4, producto.getIdCategoria());
			
			filas = pst.executeUpdate(); 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return filas; 
	}
	
	
	// Listado
	public ArrayList<Producto> tablaProductos(){
		String consulta = "SELECT Codigo, Nombre, Precio, Stock, IdCategoria FROM Productos"; 
		
		Connection cn = null;  
		ArrayList<Producto> aProductos = new ArrayList<Producto>(); 
		try {
			cn = obtenerConexion(); 
			Statement st = cn.createStatement(); 
			ResultSet rst = st.executeQuery(consulta);  
			
			while(rst.next()) {
				Producto prod = new Producto(); 
				prod.setCodigo(rst.getString("Codigo"));
				prod.setNombre(rst.getString("Nombre"));
				prod.setPrecio(rst.getFloat("Precio"));
				prod.setStock(rst.getInt("Stock"));
				prod.setIdCategoria(rst.getInt("IdCategoria"));
				aProductos.add(prod); 
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cn != null) {
					cn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aProductos; 
	}

}
