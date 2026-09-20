package Main;

import Dao.DaoCategorias;
import Dao.DaoProductos;
import Entidades.Categorias;
import Entidades.Producto;

public class Principal {

	public static void main(String[] args) {
		DaoCategorias daoCat = new DaoCategorias();		
		DaoProductos daoProductos = new DaoProductos(); 
		
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
		

        if(daoCat.eliminarCategoria(5))
        {
            System.out.println("Categoria eliminada con exito");
        }
        else
        {
            System.out.println("Error al eliminar categoria");
        }
        
		
		for (Producto producto : productos) {
			if(daoProductos.agregarProducto(producto)) {
				System.out.println("Productos agregados con exito");
			}
			else {
				System.out.println("Error al cargar los productos");
			}
		}
		
	}

}
