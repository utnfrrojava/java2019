package entidades;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido;
	
	public Persona() {
		this.setDni("00000000");
		this.setApellido("Don");
		this.setNombre("Nadie");
	}
	
	public Persona(String dni, String nombre, String apellido) {
		this();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni=dni;
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

	public String getDetalle(boolean incluirDatosSensibles) {
		String det="";
		if (incluirDatosSensibles) {
			det=det+"DNI: "+this.getDni()+" - ";
		}
		det+=this.getApellido()+", "+this.getNombre();
		return det;
	}
	
	public String getDetalle() {
		return this.getDetalle(true);
	}
	
}
