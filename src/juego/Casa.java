package juego;

import java.awt.Color;

import entorno.Entorno;

public class Casa {
	private double x;
	  private double y;
	  private int alto; //fijo
	  private int ancho; //fijo
	  private double angulo;
	  private Color color;
	
	// Constructor casa
	public Casa(double x, double y, int alto, int ancho, double angulo, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.angulo = angulo;
		this.color = color;
		
	}
	
	// Dibujador de casa
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
	}
	  
	  
}
