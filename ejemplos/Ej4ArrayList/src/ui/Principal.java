package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		boolean cont=true;
		
		ArrayList<String> palabras = new ArrayList<String>();
		while (cont) {
			System.out.println();
			
			System.out.print("Ingrese una palabra: ");
			String pal=s.nextLine();
			
			palabras.add(pal);
			
			System.out.println();
			System.out.println("¿Desea continuar? (S/N)");
			
			cont=(s.nextLine().equalsIgnoreCase("s"));
		}
		
		
		System.out.println("Palabras ingresadas: "+palabras.size());
		System.out.println("######################");
		for (String pal : palabras) {
			System.out.println(pal);
		}
		
		System.out.println("Ultima palabra: "+
							palabras.get(palabras.size()-1));
		
		System.out.println();
		
		System.out.print("Ingrese palabra a buscar: ");
		String aBuscar=s.nextLine();
		String contiene;
		
		if(palabras.contains(aBuscar)) { 
			//contains utiliza el método equals de la clase asociada al arraylist 
			contiene="si";
		}else {
			contiene="no";
		}
		System.out.println("El ArrayList palabras "+contiene+" la palabra "+
							aBuscar+" en la posición "+
							palabras.indexOf(aBuscar));
							//si no lo encuentra indexOf devuelve -1
		
		System.out.println();
		
		System.out.print("Ingrese una palabra a insertar: ");
		String aInsertar=s.nextLine();
		System.out.print("Ingrese una posición para insertarlo: ");
		int pos=Integer.parseInt(s.nextLine());
		
		palabras.add(pos, aInsertar);
		System.out.println("Palabras modificadas:");
		System.out.println("#####################");
		for (String pal : palabras) {
			System.out.println(pal);
		}	
		
		
		System.out.println();
		
		System.out.print("Ingrese una palabra de reemplazo: ");
		String aReemplazar=s.nextLine();
		System.out.print("Ingrese una posición para reemplazar: ");
		int posReemp=Integer.parseInt(s.nextLine());
		
		palabras.set(posReemp, aReemplazar);
		
		System.out.println("Palabras modificadas:");
		System.out.println("#####################");
		for (String pal : palabras) {
			System.out.println(pal);
		}		
		
		System.out.println();
		
		System.out.print("Ingrese una palabra a eliminar: ");
		String aEliminar=s.nextLine();
		palabras.remove(aEliminar);
		System.out.println("Palabras modificadas:");
		System.out.println("#####################");
		for (String pal : palabras) {
			System.out.println(pal);
		}		
		
		System.out.println();
		
		System.out.print("Ingrese una posición a eliminar: ");
		int posElim=Integer.parseInt(s.nextLine());
		palabras.remove(posElim);
		System.out.println("Palabras modificadas:");
		System.out.println("#####################");
		for (String pal : palabras) {
			System.out.println(pal);
		}		
		
		
		s.close();
		
		
		
	}

}
