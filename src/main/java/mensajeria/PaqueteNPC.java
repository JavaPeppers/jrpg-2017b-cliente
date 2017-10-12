package mensajeria;

import java.io.Serializable;

import dominio.NonPlayableCharacter;
import estados.Estado;

public class PaqueteNPC extends Paquete implements Serializable, Cloneable {

	private NonPlayableCharacter npc;
	private int posX;
	private int posY;
	private int id;
	private int idMapa;
	private int estado;
	//private int saludTope;
	//private int energiaTope;
	//private int fuerza;
	//private int destreza;
	//private int inteligencia;
	private int nivel = 1;
	
	private static final int DIFICULTADNPC = 1;
	
	public PaqueteNPC() {
		
	}
	
	public PaqueteNPC(int posX, int posY, int id, String nombre, int idMapa) {
		this.estado = Estado.estadoJuego;
		this.posX = posX;
		this.posY = posY;
		this.id = id;
		this.idMapa = idMapa;
		this.npc = new NonPlayableCharacter(nombre, nivel, DIFICULTADNPC );
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getMapa(){
		return idMapa;
	}

	public void setMapa(int mapa){
		idMapa = mapa;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
//	public int getSaludTope() {
//		return saludTope;
//	}
//
//
//	public void setSaludTope(int saludTope) {
//		this.saludTope = saludTope;
//	}
//
//
//	public int getEnergiaTope() {
//		return energiaTope;
//	}
//
//
//	public void setEnergiaTope(int energiaTope) {
//		this.energiaTope = energiaTope;
//	}
//
//
//	public int getFuerza() {
//		return fuerza;
//	}
//
//
//	public void setFuerza(int fuerza) {
//		this.fuerza = fuerza;
//	}
}
