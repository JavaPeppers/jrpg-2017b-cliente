package mensajeria;

import java.io.Serializable;
import java.util.Map;

public class PaqueteDeMovimientosEnemigos extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaqueteMovimiento> enemigos;

	public PaqueteDeMovimientosEnemigos(){

	}

	public PaqueteDeMovimientosEnemigos(Map<Integer, PaqueteMovimiento> enemigos){
		this.enemigos = enemigos;
	}

	public Map<Integer, PaqueteMovimiento> getEnemigos(){
		return enemigos;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
