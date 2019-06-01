package ui;

import java.util.Scanner;

import data.*;
import entities.*;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Mostrar todo");
		DataPersona dp= new DataPersona();
		for(Persona p: dp.getAll()) {
			System.out.println(p);
		}
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("\nBusca una pesona? (S/N)");
		if(s.nextLine().equalsIgnoreCase("s")) {
			
			Persona p2=new Persona();
			p2.setDocumento(new Documento());
			
			System.out.print("Tipo doc: ");
			p2.getDocumento().setTipo(s.nextLine());
			System.out.print("Nro doc: ");
			p2.getDocumento().setNro(s.nextLine());
			System.out.println("\nBuscar persona "+
						p2.getDocumento().getTipo()+" "+
						p2.getDocumento().getNro());
			System.out.println(dp.getByDocumento(p2));

		}

		System.out.println("\nAgrega una pesona? (S/N)");
		if(s.nextLine().equalsIgnoreCase("s")) {
			Persona p1=new Persona();
			p1.setDocumento(new Documento());
			System.out.print("Nombre: ");
			p1.setNombre(s.nextLine());
			System.out.print("Apellido: ");
			p1.setApellido(s.nextLine());
			System.out.print("Tipo Doc: ");
			p1.getDocumento().setTipo(s.nextLine());
			System.out.print("Nro Doc: ");
			p1.getDocumento().setNro(s.nextLine());
			System.out.print("Email: ");
			p1.setEmail(s.nextLine());
			System.out.print("Tel: ");
			p1.setTel(s.nextLine());
			dp.add(p1);
			System.out.println("Nuevo Id: "+p1.getId());
			
		}
		
		s.close();
		
		
	}

}
