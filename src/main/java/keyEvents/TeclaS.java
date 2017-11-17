package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuStats;

public class TeclaS extends ChainOfResponsability {

	private static MenuStats menuStats;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		if (evento == KeyEvent.VK_S) {
			if (Estado.getEstado().esEstadoDeJuego()) {
				if (menuStats == null) {
					menuStats = new MenuStats(cliente);
					menuStats.setVisible(true);
				}
			}
		}else {
			next.ejecutarAccion(evento, cliente);
		}

	}

	public static MenuStats getMenuStats() {
		return menuStats;
	}

	public static void setMenuStats(MenuStats menuStats) {
		TeclaS.menuStats = menuStats;
	}
	
}
