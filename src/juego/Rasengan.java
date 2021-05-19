package juego;

import java.awt.Color;

import entorno.Entorno;

public class Rasengan {
	private double x;
	private double y;
	private double radio;
	private double velocidad;
	private int direccion;
	
	public Rasengan(double x, double y,int dir) {
		super();
		this.x = x;
		this.y = y;
		this.radio = 20;
		this.velocidad = 5;
		this.direccion = dir;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	//Movimiento del Rasengan
	 public void mover() {
    	if(this.direccion == 0) {
    		this.x+=this.velocidad;
    	}if(this.direccion == 4) {
    		this.y+=this.velocidad;
    	}
    	
    }
	//Dibuja Rasengan
	public void Dibujar(Entorno entorno) {
			entorno.dibujarCirculo(x, y, radio, Color.WHITE);
		}
}
