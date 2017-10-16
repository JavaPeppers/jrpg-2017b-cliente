package mensajeria;

import java.io.Serializable;

public class PaqueteMovEnemigo extends Paquete implements Serializable, Cloneable {

	private int id;
	private float posX;
	private float posY;
	private int direccion;
	private int frame;

	public PaqueteMovEnemigo() {
		setComando(Comando.MOVIMIENTO);
	}

	public PaqueteMovEnemigo(int idPersonaje) {
		id = idPersonaje;
		setComando(Comando.MOVIMIENTO);
	}

	public PaqueteMovEnemigo(int idPersonaje, float posX, float posY) {
		this.id = idPersonaje;
		this.posX = posX;
		this.posY = posY;
		setComando(Comando.MOVIMIENTO);
	}

	public int getIdEnemigo() {
		return id;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.id = idEnemigo;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
