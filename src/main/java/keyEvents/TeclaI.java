package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuInventario;

public class TeclaI extends ChainOfResponsability {

	private static MenuInventario menuInventario;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		if (evento == KeyEvent.VK_I) {
			if (Estado.getEstado().esEstadoDeJuego()) {
				if (menuInventario == null) {
					menuInventario = new MenuInventario(cliente);
					menuInventario.setVisible(true);
				}
			}

		}else {
			next.ejecutarAccion(evento, cliente);
		}

	}

	public static MenuInventario getMenuInventario() {
		return menuInventario;
	}

	public static void setMenuInventario(MenuInventario menuInventario) {
		TeclaI.menuInventario = menuInventario;
	}
	
}
