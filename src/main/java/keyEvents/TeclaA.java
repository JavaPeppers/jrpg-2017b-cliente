package keyEvents;

import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;

public class TeclaA extends ChainOfResponsability {

	private static MenuAsignarSkills menuAsignar;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		if (evento == KeyEvent.VK_A) {
			if (Estado.getEstado().esEstadoDeJuego()) {
				if (menuAsignar == null) {
					menuAsignar = new MenuAsignarSkills(cliente);
					menuAsignar.setVisible(true);
				}
			}
		}else {
			next.ejecutarAccion(evento, cliente);
		}

	}

	public static MenuAsignarSkills getMenuAsignar() {
		return menuAsignar;
	}

	public static void setMenuAsignar(MenuAsignarSkills menuAsignar) {
		TeclaA.menuAsignar = menuAsignar;
	}
	
	

}
