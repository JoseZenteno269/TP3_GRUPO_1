package Entidades;

public class Producto {
	private String Codigo;
	private String Nombre;
	private float Precio;
	private int Stock;
	private int IdCategoria;
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int IdCategoria) {
		this.IdCategoria = IdCategoria;
	}
	
	@Override
	public String toString() {
		return "Producto [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Stock=" + Stock
				+ ", Id Categoria=" + IdCategoria + "]";
	}
	
	
}
