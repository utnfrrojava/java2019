package ui;

import java.util.Collections;
import java.util.LinkedList;

import entidades.*;

public class Principal {
	
	public static void main(String[] args) {
		LinkedList<Persona> personas= new LinkedList<Persona>();
		
		personas.add(new Persona(new Documento("Pasaporte",1212121212),"Nadie","Sabe"));
		personas.add(new Persona(new Documento("dni",13131313),"Otro", "Más"));
		personas.add(new Persona(new Documento("cuit",14141414),"Identidad", "Desconocida"));
		personas.add(new Persona(new Documento("dni",10101010),"Juan", "Perez"));
		personas.add(new Persona(new Documento("cuit",1111111111),"John", "Doe"));
		personas.add(new Persona(new Documento("cuit",14141414),"Juana", "Perez"));
		
		
		System.out.println(personas.get(1).compareTo(personas.get(3)));
		PersonaLexicographicComparator pc=new PersonaLexicographicComparator();
		
		System.out.println(pc.compare(personas.get(0), personas.get(1)));
		Collections.sort(personas,pc);
		
		System.out.println();
		System.out.println("Listado");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}
}
