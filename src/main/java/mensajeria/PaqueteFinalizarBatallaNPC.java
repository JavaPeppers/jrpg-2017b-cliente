package mensajeria;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PaqueteFinalizarBatallaNPC extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int ganadorBatalla;
	public PaqueteFinalizarBatallaNPC(){
		setComando(Comando.FINALIZARBATALLANPC);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}

	public int getGanadorBatalla() {
		return ganadorBatalla;
	}

	public void setGanadorBatalla(int ganadorBatalla) {
		this.ganadorBatalla = ganadorBatalla;
	}
}
