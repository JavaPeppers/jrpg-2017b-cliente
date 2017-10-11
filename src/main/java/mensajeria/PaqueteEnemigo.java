package mensajeria;

import java.io.Serializable;
import estados.Estado;
import java.io.IOException;
import java.io.Serializable;

public class PaqueteEnemigo extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idMapa;
	private int estado;
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private String nombre;
	private static int NIVEL = 1;
	private int posX;
	private int posY;
	
	
	public PaqueteEnemigo() {
		this.estado = Estado.estadoOffline;
	}
	
	public PaqueteEnemigo(int id, String nombre, int posX, int posY) {
		this.id = id;
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getIdMapa() {
		return idMapa;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getEstado() {
		return estado;
	}

	public int getMapa(){
		return idMapa;
	}
	
	public int getId() {
		return id;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public int getFuerza() {
		return fuerza;
	}
	
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}
