package mensajeria;

import java.io.Serializable;
import java.util.Map;

import dominio.NonPlayableCharacter;

public class PaqueteDeTodosLosNpc extends Paquete implements Serializable, Cloneable{
	
	private Map<Integer, PaqueteNPC> npcs;

	public PaqueteDeTodosLosNpc(){

	}

	public PaqueteDeTodosLosNpc(Map<Integer, PaqueteNPC> npcs){
		this.npcs = npcs;
	}

	public Map<Integer, PaqueteNPC> getNPCS(){
		return npcs;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}


}
