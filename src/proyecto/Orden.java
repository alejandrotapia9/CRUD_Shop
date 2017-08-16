package proyecto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orden {
	private int id_orden;
	private String fecha;
	private Producto producto;
	private int usuario;
	private int cantidad;
	
	public Orden(){
		super();
	}	
	
	public Orden(int id, String fecha, Producto producto, int usuario,int cantidad) {
		super();
		this.id_orden = id;
		this.fecha = fecha;
		this.producto = producto;
		this.usuario = usuario;	
		this.cantidad = cantidad;
	}

	public Orden(Producto producto, int usuario,int cantidad) {
		super();
		this.producto = producto;
		this.usuario = usuario;	
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_orden() {
		return id_orden;
	}

	public void setId_orden(int id_orden) {
		this.id_orden = id_orden;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int us) {
		this.usuario = us;
	}
	
	
}