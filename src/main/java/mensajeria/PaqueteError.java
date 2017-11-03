package mensajeria;

import java.io.Serializable;

public class PaqueteError extends Paquete implements Serializable, Cloneable  {

	public PaqueteError() {
		setComando(Comando.COMANDOERROR);
	}
}
