package entidades;

import java.math.BigInteger;

public class Documento implements Comparable<Documento>{
	private String tipo;
	private long nro;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getNro() {
		return nro;
	}
	public void setNro(long nro) {
		this.nro = nro;
	}
	
	public Documento() {}
	
	public Documento(String tipo, long nro) {
		this.setTipo(tipo);
		this.setNro(nro);
	}

	@Override
	public String toString() {
		return "tipo=" + tipo + ", nro=" + nro + " - ";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (nro ^ (nro >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (!(obj instanceof Documento)) {
			return false;
		}
		Documento other = (Documento) obj;
		if (nro != other.nro) {
			return false;
		}
		if (tipo == null) {
			if (other.tipo != null) {
				return false;
			}
		} else if (!tipo.equals(other.tipo)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Documento o) {
		int comp=tipo.compareTo(o.getTipo());
		if(comp==0) {
			comp=(int)(nro - o.getNro());
		}
		return comp;
	}
	
}
