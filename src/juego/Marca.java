package juego;

import java.awt.Color;

import entorno.Entorno;

public class Marca {

	private double x;
	private double y;
	private double diametro;
	private Color color;
	
	public Marca(double x, double y, double diametro, Color colorin) {
		this.x = x;
		this.y= y;
		this.diametro = diametro;
		this.color = colorin;
	}
	
	public void dibujarMarca(Entorno e) {
		e.dibujarCirculo(x, y, diametro, color);
	}
}
