package logic;

import java.util.ArrayList;

import data.DataPersona;
import entities.*;

public class PersonaControler {

	DataPersona dp;
	
	public PersonaControler() {
		dp=new DataPersona();
		
	}
	
	public ArrayList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getById(Persona per){
		return dp.getById(per);
	}
	
	public Persona getByUser(Persona per){
		return dp.getByUser(per);
	}
	
	public void delete(Persona per) {
		dp.delete(per);
	}
}
