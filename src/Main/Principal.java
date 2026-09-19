package Main;

import Dao.DaoCategorias;
import Entidades.Categorias;

public class Principal {

	public static void main(String[] args) {
		DaoCategorias daoCat = new DaoCategorias();		
		
		Categorias[] categorias = 

			{
					new Categorias(1,"Lacteos"),
					new Categorias(2,"Limpieza"),
					new Categorias(3, "Electrodomesticos"),
					new Categorias(4, "Indumentaria"),
					new Categorias(5, "Bebidas")
					
			};
		
		for(Categorias cate : categorias)
		{
			int filas = daoCat.agregarCategoria(cate);
			
			if(filas == 1)
			{
				System.out.println("Categoria agregada con exito");
			}
			else 
			{
				System.out.println("Error al agregar categoria");
			}
		}
		
        int filasBaja = daoCat.eliminarCategoria(3);

        if(filasBaja == 1)
        {
            System.out.println("Categoria eliminada con exito");
        }
        else
        {
            System.out.println("Error al eliminar categoria");
        }
		
	}

}
