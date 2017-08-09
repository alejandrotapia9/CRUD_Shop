package proyecto;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Rol {
	int id;
	String tipo;	
		
	public Rol(String tipo) throws Exception {
		super();		
		this.tipo = tipo;					
	}
	
	
	public Rol() throws Exception {		
		super();		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}		
	
}
