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
}
