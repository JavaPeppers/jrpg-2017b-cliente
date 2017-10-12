package mensajeria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import dominio.NonPlayableCharacter;

public class PaqueteDeTodosLosNpc extends Paquete implements Serializable, Cloneable{
	
	private HashMap<Integer, PaqueteNPC> npcs;

	public PaqueteDeTodosLosNpc(){
		npcs = new HashMap<Integer, PaqueteNPC>();
	}

	public PaqueteDeTodosLosNpc(HashMap<Integer, PaqueteNPC> npcs){
		this.npcs = npcs;
	}

	public HashMap<Integer, PaqueteNPC> getNPCS(){
		return npcs;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}


}
