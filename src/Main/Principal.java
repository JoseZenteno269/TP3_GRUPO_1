package Main;

import Dao.DaoCategorias;
import Dao.DaoProductos;
import Entidades.Categorias;
import Entidades.Producto;

public class Principal {

	public static void main(String[] args) {
		DaoCategorias daoCat = new DaoCategorias();		
		DaoProductos daoProd = new DaoProductos(); 
		
		Categorias[] categorias = 

			{
					new Categorias("Lacteos"),
					new Categorias("Limpieza"),
					new Categorias("Electrodomesticos"),
					new Categorias("Indumentaria"),
					new Categorias("Bebidas")
					
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
		
		/// Dar de alta
		for(Categorias cate : categorias)
		{
			if(daoCat.agregarCategoria(cate))
			{
				System.out.println("Categoria agregada con exito");
			}
			else 
			{
				System.out.println("Error al agregar categoria");
			}
		}
		
		///Modificar
		
		Categorias categoriaModificar = new Categorias();

		categoriaModificar.setIdCategoria(3);
		categoriaModificar.setNombre("Tecnologia");

		if(daoCat.modificarCategoria(categoriaModificar))
		{
		    System.out.println("Categoria modificada con exito");
		}
		else
		{
		    System.out.println("Error al modificar categoria");
		}
		
		Producto modificarProducto = new Producto();

		modificarProducto.setCodigo("PROD-010");
		modificarProducto.setNombre("Lavaropa");
		modificarProducto.setPrecio(45000);
		modificarProducto.setStock(100);
		modificarProducto.setIdCategoria(3);

		if(daoProd.modificarProducto(modificarProducto))
		{
		    System.out.println("Producto modificado con exito");
		}
		else
		{
		    System.out.println("Error al modificar el Producto");
		}

		
		///Dar de baja
		
        if(daoCat.eliminarCategoria(5))
        {
            System.out.println("Categoria eliminada con exito");
        }
        else
        {
            System.out.println("Error al eliminar categoria");
        }
        
		
		for (Producto producto : productos) {
			if(daoProd.agregarProducto(producto)) {
				System.out.println("Productos agregados con exito");
			}
			else {
				System.out.println("Error al cargar los productos");
			}
		}

		/// Listados
		System.out.println("\nListado de categorias:");
		for (Categorias categoria : daoCat.listarCategorias()) {
			System.out.println(categoria);
		}

		System.out.println("\nListado de productos:");
		for (Producto producto : daoProd.tablaProductos()) {
			System.out.println(producto);
		}
		
	}

}
