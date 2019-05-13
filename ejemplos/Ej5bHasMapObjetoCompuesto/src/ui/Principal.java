package ui;

import java.util.HashMap;

import entidades.*;

public class Principal {

	public static void main(String[] args) {
		HashMap<Documento, Persona> personas= new HashMap<Documento, Persona>();
		Persona p1= new Persona(new Documento("dni",10101010),"Juan", "Perez");
		Persona p2= new Persona(new Documento("dni",11111111),"John", "Doe");
		
		personas.put(p1.getDocumento(), p1);
		personas.put(p2.getDocumento(), p2);
		
		System.out.print("Contiene dni 11111111? ");
		System.out.println(personas.containsKey(new Documento("dni",11111111)));
		System.out.println(personas.get(new Documento("dni",11111111)));
		
		System.out.print("Contiene DNI 11111111? ");
		System.out.println(personas.containsKey(new Documento("DNI",11111111)));
		System.out.println(personas.get(new Documento("DNI",11111111)));
	}
	
}
