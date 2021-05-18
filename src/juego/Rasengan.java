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
		this.x = x;
		this.y = y;
		this.radio = 5;
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
		if (this.direccion == 1) {
			moverDerecha();
		} else if (this.direccion ==2) {
			moverIzquierda();
		}if (this.direccion ==4) {
			moverArriba();
		} else if (this.direccion == 3) {
			moverAbajo();
		}
	}
	//Mueve el ninja hacia la derecha en caso que corresponda
	private void moverDerecha() {
		if(this.x >= 800) {
			this.x = 0;
		}
		this.x = this.x + this.velocidad;
	}
	//Mueve el ninja hacia la izquierda enl caso que corresponda
	private void moverIzquierda() {
		if(this.x <= 0) {
			this.x = 800;
		}
		this.x = this.x - this.velocidad;
	}
	private void moverArriba() {
		if(this.y >= 800) {
			this.y = 0;
		}
		this.y = this.y + this.velocidad;
	}
	private void moverAbajo() {
		if(this.y <= 0) {
			this.y = 800;
		}
		this.y = this.y - this.velocidad;
	}
		
	
	//Dibuja Rasengan
	public void Dibujar(Entorno entorno) {
			entorno.dibujarCirculo(x, y, radio, Color.WHITE);
		}
	
}
