package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.Enemigo;
import mensajeria.PaqueteEnemigo;
import recursos.Recursos;

public class EstadoEnemigo {

	private static final int ANCHOBARRA = 122;
	private static final int ALTOSALUD = 14;
	private static final int ALTOMINIATURA = 64;
	private static final int ANCHOMINIATURA = 64;

	public static void dibujarEstadoDeEnemigo(Graphics g, int x, int y, Enemigo enemigo, BufferedImage miniaturaEnemigo){

		int drawBarra = 0;

		g.drawImage(Recursos.estadoPersonaje, x, y, null);

		g.drawImage(miniaturaEnemigo, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);

		if(enemigo.getSalud() == enemigo.getSaludTope()) {
			drawBarra = ANCHOBARRA;
		} else {
			drawBarra = (enemigo.getSalud() * ANCHOBARRA) / enemigo.getSaludTope();
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud,  x + 80, y + 26, drawBarra, ALTOSALUD, null);
		g.drawString(String.valueOf(enemigo.getSalud()) + " / " + String.valueOf(enemigo.getSaludTope()), x + 132, y + 37);

		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(enemigo.getNivel()), x + 59, y + 70);


	}

	public static void dibujarEstadoDeEnemigo(Graphics g, int x, int y, PaqueteEnemigo enemigo, BufferedImage miniaturaEnemigo){

		
		int drawBarra = 0;

		g.drawImage(Recursos.estadoPersonaje, x, y, null);

		g.drawImage(miniaturaEnemigo, x + 10, y + 9, ANCHOMINIATURA, ALTOMINIATURA, null);

	
		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud, x + 80, y + 26, drawBarra, ALTOSALUD, null);
		g.drawString(String.valueOf(enemigo.getSaludTope()) + " / " + String.valueOf(enemigo.getSaludTope()), x + 132, y + 37);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(enemigo.getNivel()), x + 59, y + 70);
	}
}
