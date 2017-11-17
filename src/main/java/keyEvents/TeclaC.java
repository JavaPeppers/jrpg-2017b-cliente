package keyEvents;

import com.sun.glass.events.KeyEvent;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;

public class TeclaC extends ChainOfResponsability {

	private static VentanaContactos ventContac;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		if (evento == KeyEvent.VK_C) {
			if (Estado.getEstado().esEstadoDeJuego()) {
				if (ventContac == null) {
					ventContac = new VentanaContactos(cliente.getJuego());
					ventContac.setVisible(true);
				}

			}
		}
	}

	public static VentanaContactos getVentContac() {
		return ventContac;
	}

	public static void setVentContac(VentanaContactos ventContac) {
		TeclaC.ventContac = ventContac;
	}
	
}
