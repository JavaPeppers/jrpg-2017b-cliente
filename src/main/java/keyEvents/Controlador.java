package keyEvents;

import cliente.Cliente;

public class Controlador extends ChainOfResponsability {
	
	private static TeclaI menuInventario;
	private static TeclaA menuAsignar;
	private static TeclaS menuStats;
	private static TeclaEsc menuEscape;
	private static TeclaC ventContac;

	@Override
	public void ejecutarAccion(int evento, Cliente cliente) {
		
		menuInventario = new TeclaI();
		this.setNext(menuInventario);
		
		menuAsignar = new TeclaA();
		menuInventario.setNext(menuAsignar);
		
		menuStats = new TeclaS();
		menuAsignar.setNext(menuStats);
		
		menuEscape = new TeclaEsc();
		menuStats.setNext(menuEscape);
		
		ventContac = new TeclaC();
		menuEscape.setNext(ventContac);
		
		next.ejecutarAccion(evento, cliente);
		
	}

}
