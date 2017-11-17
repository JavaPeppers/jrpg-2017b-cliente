package keyEvents;

import cliente.Cliente;

public abstract class ChainOfResponsability {
	
	protected ChainOfResponsability next;
		
	public abstract void ejecutarAccion(int evento, Cliente cliente);

	public ChainOfResponsability getNext() {
		return next;
	}

	public void setNext(ChainOfResponsability next) {
		this.next = next;
	}

}
