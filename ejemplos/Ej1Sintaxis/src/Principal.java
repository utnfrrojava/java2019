import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String[] palabras= new String[3];
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("Ingrese la "+(i+1)+"° palabra: ");
			palabras[i]=lector.nextLine();
			
		}
		System.out.println("");
		System.out.println("Palabras for");
		for (int i = palabras.length-1; i >=0 ; i--) {
			System.out.println(palabras[i]);
		}
		
		
		System.out.println();
		System.out.println("Palabras for normal");
		for (int i = 0; i <palabras.length ; i++) {
			String pal=palabras[i];
			System.out.println(pal);
		}
	
		System.out.println();
		System.out.println("Palabras foreach");
		
		for (String pal : palabras) {
			System.out.println(pal);
		}
	
		System.out.println();
		System.out.println("Ingrese palabra a Comparar: ");
		
		String palabraComparar=lector.nextLine();
		
		System.out.println("Resultado");
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("palabras["+i+"] => "+palabras[i]);
			System.out.println("palabras["+i+"] == palabraComparar =>"+
					(palabras[i]==palabraComparar));
			System.out.println("palabras["+i+"].equals(palabraComparar) =>"+
					palabras[i].equals(palabraComparar));
			System.out.println("palabras["+i+"].equalsIgnoreCase(palabraComparar) =>"+
					palabras[i].equalsIgnoreCase(palabraComparar));
			System.out.println();
		}
		
		
		lector.close();

	}

}
