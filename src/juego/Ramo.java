package juego;

import java.awt.Color;

import entorno.Entorno;

public class Ramo {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private Color color;
	private double movimiento;
	private int cantidadFlores=0;
	
	public Ramo(double x, double y, double ancho, double alto, Color color, double movimiento) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.movimiento = movimiento;
		
	}
	public void dibujar (Entorno e) {

		e.dibujarRectangulo(x, y, ancho, alto, 0, color);
		
	}
	public void cantFloresRepartidas() {
		this.cantidadFlores+=1;
	}
	
	
	public double getX() {
		return x;
	}	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setMovimiento(double movimiento) {
		this.movimiento = movimiento;
	}
	public double getY() {
		return y;
	}
	public double getAncho() {
		return ancho;
	}
	public double getAlto() {
		return alto;
	}
	public Color getColor() {
		return color;
	}
	public double getMovimiento() {
		return movimiento;

	}
	}

	


