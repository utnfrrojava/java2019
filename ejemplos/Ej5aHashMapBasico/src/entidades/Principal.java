package entidades;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		HashMap<Integer,Persona> personas=new HashMap<Integer, Persona>();
		
        Persona p1=new Persona(123, "Juan", "Perez");
        Persona p2=new Persona(456, "John", "Doe");
        Persona pRep=new Persona(456, "J", "Doe");
        Persona p3=new Persona(678, "Nadie", "Sabe");
        Persona p4=new Persona(901, "Fulano", "de Tal");
        Persona p5=new Persona(901, "Identidad", "Desconocida");
        
        personas.put(p1.getDni(), p1);
        personas.put(p2.getDni(), p2);
        personas.put(pRep.getDni(), pRep);
        personas.put(p3.getDni(), p3);
        personas.put(p4.getDni(), p4);
        personas.put(p5.getDni(), p5);
        
        System.out.println("Size:" +personas.size());
        
        System.out.println("");
        System.out.println("foreach values");
        for (Persona p : personas.values()) {
			System.out.println(p);
		}
        
        System.out.println("");
        System.out.println("foreach entries");
        
        for (Map.Entry item: personas.entrySet()) {
        	Integer clave=(Integer)item.getKey();
        	Persona per=(Persona)item.getValue();
        	System.out.println("Key: "+clave+", Valor: "+per);
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Iterator");
        Iterator it=personas.keySet().iterator();

        while(it.hasNext()) {
            Integer key= (Integer)it.next();
            System.out.println("Key: "+key+", Value: "+personas.get(key));
        }
        
        System.out.println("");

        personas.remove(678);
        printForeach(personas, "removed p3");
        
        System.out.println("");
        System.out.println("Contains");
        System.out.println("Contains key "+p2.getDni()+"? "+personas.containsKey(p2.getDni()));
        System.out.println("Contains value "+p2.getDni()+"? "+personas.containsValue(p2.getDni()));
        System.out.println("Contains value p2? "+personas.containsValue(p2));
        System.out.println("Contains value pRep? "+personas.containsValue(pRep));
        
        
        Persona pNew=new Persona(456, "J", "Doe"); //nunca se hace put a personas
        System.out.println("");
        System.out.println("Contains pNew");
        System.out.println("Contains key "+pNew.getDni()+"? "+personas.containsKey(pNew.getDni()));
        System.out.println("Contains value "+pNew.getDni()+"? "+personas.containsValue(pNew.getDni()));
        System.out.println("Contains value pNew? "+personas.containsValue(pNew));

        
        
        
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("get");

        System.out.println("Persona con dni 123: "+ personas.get(123));
        System.out.println("Persona con dni 666: "+ personas.get(66));
        
        HashMap<Integer, Persona> personas2= new HashMap<Integer, Persona>(personas);
        printForeach(personas2, "personas2");
        
        Map<Integer, Persona> sortedPersonas = new TreeMap<Integer, Persona>(personas2);
        printForeach(sortedPersonas, "sort");
        
	}

	private static void printForeach(Map<Integer, Persona> personas, String title) {
        System.out.println("");
        System.out.println("");
        System.out.println(title);
        for (Map.Entry entry: personas.entrySet()) {
                System.out.println("Key: "+entry.getKey()+", Value: "+entry.getValue());
        }

		
	}

}
