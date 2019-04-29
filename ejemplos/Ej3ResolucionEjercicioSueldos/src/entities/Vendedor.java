package entities;

public class Vendedor extends Empleado{
	private double porcenComision;
	private double totalVtas;
	
	public double getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(double porcenComision) {
		this.porcenComision = porcenComision;
	}
	public double getTotalVtas() {
		return totalVtas;
	}
	public void setTotalVtas(double totalVtas) {
		this.totalVtas = totalVtas;
	}
	
	public double getSueldo() {
		return this.getSueldoBase()+
				((this.getTotalVtas()*this.getPorcenComision())/100);
	}
}
