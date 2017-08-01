package proyecto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Orden {
	public String nombre;
	public String apellido;
	public String mail;
	public String peso;
	public String academia;
	public String cinturon;
	
	public Orden(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAcademia() {
		return academia;
	}

	public void setAcademia(String academia) {
		this.academia = academia;
	}

	public String getCinturon() {
		return cinturon;
	}


	public void setCinturon(String cinturon) {
		this.cinturon = cinturon;
	}
	
	
	
}