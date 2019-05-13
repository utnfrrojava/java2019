package entidades;

public class Persona {
	private int id;
	private Documento documento;
	private String nombre;
	private String apellido;
	private String email;
	private String tel;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return
				"\nPersona: "+this.getId()+
				"\nTipo Doc: "+getDocumento().getTipo()+
				"\nNro Doc: "+getDocumento().getNro()+
				"\nNombre: "+getNombre()+
				"\nApellido: "+getApellido()+
				"\nEmail: "+getEmail()+
				"\nTelefono: "+getTel();
	}

}
