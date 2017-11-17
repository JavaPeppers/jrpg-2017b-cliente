package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuEscape;

public class TeclaEsc extends ChainOfResponsability {

	private static MenuEscape menuEscp;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		if (evento == KeyEvent.VK_ESCAPE) {
			if (Estado.getEstado().esEstadoDeJuego()) {
				if (menuEscp == null) {
					menuEscp = new MenuEscape(cliente);
					menuEscp.setVisible(true);
				}
			}
		}else {
			next.ejecutarAccion(evento, cliente);
		}

	}

	public static MenuEscape getMenuEscp() {
		return menuEscp;
	}

	public static void setMenuEscp(MenuEscape menuEscp) {
		TeclaEsc.menuEscp = menuEscp;
	}
	
}
