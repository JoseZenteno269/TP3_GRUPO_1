package Main;

import Dao.DaoCategorias;
import Dao.DaoProductos;
import Entidades.Categorias;
import Entidades.Producto;

public class Principal {

	public static void main(String[] args) {
		DaoCategorias daoCategoria = new DaoCategorias();		
		DaoProductos daoProducto = new DaoProductos(); 
		
		Categorias[] categorias = 

			{
					new Categorias("Lacteos"),
					new Categorias("Limpieza"),
					new Categorias("Electrodomesticos"),
					new Categorias("Indumentaria"),
					new Categorias("Bebidas"),
					new Categorias("Alimentos")
					
			};
		
		
		Producto[] productos = 
			{
			    new Producto("PROD-000", "Leche", 1500, 30, 1),
			    new Producto("PROD-001", "Yogur", 1200, 25, 1),
			    new Producto("PROD-002", "Detergente", 1800, 20, 2),
			    new Producto("PROD-003", "Lavandina", 1300, 35, 2),
			    new Producto("PROD-004", "Microondas", 120000, 8, 3),
			    new Producto("PROD-005", "Licuadora", 65000, 12, 3),
			    new Producto("PROD-006", "Remera", 15000, 20, 4),
			    new Producto("PROD-007", "Pantalon", 30000, 15, 4),
			    new Producto("PROD-008", "Coca Cola", 2500, 40, 5),
			    new Producto("PROD-009", "Agua Mineral", 1200, 50, 5)
			}; 
		
		
		/// Dar alta Categorias y Productos
		
		for(Categorias cate : categorias)
		{
			if(daoCategoria.agregarCategoria(cate))
			{
				System.out.println("Categoria agregada con exito");
			}
			else 
			{
				System.out.println("Error al agregar categoria");
			}
		}
		
		
		
		for (Producto producto : productos) {
			if(daoProducto.agregarProducto(producto)) {
				System.out.println("Productos agregados con exito");
			}
			else {
				System.out.println("Error al cargar los productos");
			}
		}
		
		
		/// Dar baja Categorias y Productos 
		
		if(daoProducto.eliminarProducto("PROD-003")) {
			System.out.println("Producto eliminado correctamente");
		}
		else {
			System.out.println("Error al eliminar un producto");
		}
		
		
		if(daoCategoria.eliminarCategoria(6))
		{
			System.out.println("Categoria eliminada con exito");
		}
		else
		{
			System.out.println("Error al eliminar categoria");
		}
		
		
		/// Modificar Categorias y Productos
		
		Categorias categoriaModificar = new Categorias();

		categoriaModificar.setIdCategoria(3);
		categoriaModificar.setNombre("Tecnologia");

		if(daoCategoria.modificarCategoria(categoriaModificar))
		{
		    System.out.println("Categoria modificada con exito");
		}
		else
		{
		    System.out.println("Error al modificar categoria");
		}
		
		Producto modificarProducto = new Producto();

		modificarProducto.setCodigo("PROD-005");
		modificarProducto.setNombre("Lavaropa");
		modificarProducto.setPrecio(350000);
		modificarProducto.setStock(30);
		modificarProducto.setIdCategoria(3);

		if(daoProducto.modificarProducto(modificarProducto))
		{
		    System.out.println("Producto modificado con exito");
		}
		else
		{
		    System.out.println("Error al modificar el Producto");
		}
		
		

		/// Listar Categorias y Productos
		
		System.out.println("\nListado de categorias:");
		for (Categorias categoria : daoCategoria.listarCategorias()) {
			System.out.println(categoria);
		}

		System.out.println("\nListado de productos:");
		for (Producto producto : daoProducto.tablaProductos()) {
			System.out.println(producto);
		}
		
	}

}
