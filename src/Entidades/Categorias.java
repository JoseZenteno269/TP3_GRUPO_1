package Entidades;

public class Categorias {

	private int idCategoria;
	private String Nombre;
	
	//Constructores
	
	public Categorias() {}

	public Categorias(int idCategoria, String nombre) 
	{
		this.idCategoria = idCategoria;
		this.Nombre = nombre;
	}

	// Setters y getters
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	// ToString()
	@Override
	public String toString() {
		return "Categorias [idCategoria=" + idCategoria + ", Nombre=" + Nombre + "]";
	}
	
	
	
	

}