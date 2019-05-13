package entidades;

public class Persona {
	
	private Documento documento;
	private String nombre;
	private String apellido;
	
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
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
	
	public Persona() {}
	
	public Persona(Documento documento, String nombre, String apellido) {
		this.setDocumento(documento);
		this.setApellido(apellido);
		this.setNombre(nombre);
	}
	
    @Override
    public String toString(){
            return "Documento: "+getDocumento()+", Nombre: "+getNombre()+", Apellido: "+getApellido();
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		if (documento == null) {
			if (other.documento != null) {
				return false;
			}
		} else if (!documento.equals(other.documento)) {
			return false;
		}
		return true;
	}
	
    
    
    

}
