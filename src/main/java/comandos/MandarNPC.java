package comandos;

import dominio.NonPlayableCharacter;
import mensajeria.PaqueteNPC;

public class MandarNPC extends ComandosEscucha{
	@Override
	public void ejecutar() {
		NonPlayableCharacter paquete = (NonPlayableCharacter) gson.fromJson(cadenaLeida,NonPlayableCharacter.class);
		juego.getNpcs().put(paquete.getId(), paquete);
		
	}
}
