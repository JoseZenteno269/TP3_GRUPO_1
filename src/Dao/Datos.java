package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datos {
	
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "asusrog7";
    private String dbName = "bdInventario?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
    
    public Datos() {
    	
    }
    
    public Connection obtenerConexion() throws SQLException {
    	return DriverManager.getConnection(host + dbName, user, pass);
    }
    
    public int ejecutarProcedimientoAlmacenado(String consulta, Object[] parametros) {
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

}
