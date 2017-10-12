package mensajeria;

import java.io.Serializable;
import estados.Estado;
import java.io.IOException;
import java.io.Serializable;

public class PaqueteEnemigo extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idMapa;
	private String nombre;
	private int estado;
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private int nivel;
	
	
	public PaqueteEnemigo(int id) {
		super();
		this.id = id;
		idMapa = 1;
		nombre = "enemigo";
		saludTope = 100;
		energiaTope = 20;
		fuerza = 50;
		nivel = 1;
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

	public int getSaludTope() {
		return saludTope;
	}


	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}


	public int getEnergiaTope() {
		return energiaTope;
	}


	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}


	public int getFuerza() {
		return fuerza;
	}


	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
