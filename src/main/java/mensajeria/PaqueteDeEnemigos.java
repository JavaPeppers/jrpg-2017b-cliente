package mensajeria;

import java.io.Serializable;
import java.util.Map;

public class PaqueteDeEnemigos extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaqueteEnemigo> npcs;

	public PaqueteDeEnemigos(){

	}

	public PaqueteDeEnemigos(Map<Integer, PaqueteEnemigo> npcs){
		this.npcs = npcs;
	}

	public Map<Integer, PaqueteEnemigo> getNpcs(){
		return npcs;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}

