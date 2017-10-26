package mensajeria;

import java.io.Serializable;

import estados.Estado;

@SuppressWarnings("serial")
public class PaqueteEnemigo extends Paquete implements Serializable, Cloneable {
	
	private int id;
	private int idMapa;
	private String nombre;
	private int estado;
	private int saludTope;
	private int fuerza;
	private int nivel;
	private float x;
	private float y;
	
	
	public PaqueteEnemigo(int id,float x, float y) {
		this.id = id;
//		idMapa = 1;
		nombre = "Enemigo";
		estado = Estado.estadoJuego;
		saludTope = 60;
		fuerza = 25;
		nivel = 1;
		this.x=x;
		this.y=y;
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
