package comandos;

import javax.swing.JOptionPane;

import dominio.NonPlayableCharacter;
import mensajeria.PaqueteDeTodosLosNpc;
import mensajeria.PaqueteNPC;

public class MandarNPC extends ComandosEscucha{
	@Override
	public void ejecutar() {
		PaqueteDeTodosLosNpc paquete = (PaqueteDeTodosLosNpc) gson.fromJson(cadenaLeida,PaqueteDeTodosLosNpc.class);
		juego.setNpcs(paquete.getNPCS());
		JOptionPane.showMessageDialog(null,"Hola llego el paquete");
	}
}
