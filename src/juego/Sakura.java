package juego;

import java.awt.Color;

import entorno.Entorno;

public class Sakura {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private Color color;
	private double movimiento;
	

	public Sakura(double x, double y, double ancho, double alto, Color color, double movimiento) {
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
	public void moverDerecha(Entorno e,Ramo a) {
		if (!(this.x+this.ancho/2==e.ancho())) {
			  this.x+=this.movimiento;			  
		}

		if(colision(this.x,this.y,this.ancho,this.alto,a.getX(),a.getY(),a.getAlto(),a.getAncho())==true) {
			this.x-=this.movimiento;
		}
	}
	public void moverIzquierda(Ramo a) {                              // Ramo equivale a cualquier objeto para que limite el perimetro
		if (!(this.x-this.ancho/2<=0)) {
			this.x-=this.movimiento;
		}

		if(colision(this.x,this.y,this.ancho,this.alto,a.getX(),a.getY(),a.getAlto(),a.getAncho())==true) {
			this.x+=this.movimiento;
		}
		}	
	public void moverArriba(Ramo a) {
		if (!(this.y-this.alto/2<0) ) {
			this.y-=this.movimiento;
		}

		if(colision(this.x,this.y,this.ancho,this.alto,a.getX(),a.getY(),a.getAlto(),a.getAncho())==true) {
			this.y+=this.movimiento;
		}	
	}
	public void moverAbajo(Entorno e, Ramo a) {
		if (!(this.y+this.alto/2>e.alto())) {
			  this.y+=this.movimiento;		
		}

		if(colision(this.x,this.y,this.ancho,this.alto,a.getX(),a.getY(),a.getAlto(),a.getAncho())==true) {
			this.y-=this.movimiento;
		}
		
		
	}		
	public void movimiento(Entorno entorno,Ramo a) {		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			moverDerecha(entorno,a);	
		}else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))  {
			moverIzquierda(a);
		}else if (entorno.estaPresionada(entorno.TECLA_ABAJO)){
			moverAbajo(entorno,a);
		}else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)){
			moverArriba(a);	
		}
	}
	public static boolean colision(double x1, double y1, double anchoX, double altoX,double x2, double y2,double altoY, double anchoY) {    //------ pensado para dos cuadrados-------
		 if (x1<x2+anchoY  &&  x1+anchoX>x2 && y1 < y2+altoY && y1+altoX >y2) {
			 return true;
		 }else {
		return false;
		 }
	}
	public  boolean colision1(Ramo a) {
		boolean l= this.y-this.alto/2< a.getY()+a.getAlto()/2 &&
				this.x+this.ancho/2 > a.getX()-a.getAncho()/2 &&
				this.y+this.alto/2 > a.getY()-a.getAlto()/2 &&
				this.x-this.ancho/2< a.getY()+a.getAncho()/2;
				
		return l;
	}	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAncho() {
		return this.ancho;
	}
	public double getAlto() {
		return this.alto;
	}
	public double getMovimiento() {
		return this.movimiento;
	}
	public void agarrarObjeto(Ramo b) {    // terminar de pensar....
		if (colision1(b)==true) {
			b.setX(this.x);
			b.setY(this.y);
			b.setMovimiento(this.movimiento);	
		}
	}
	
	
	


	
	      
	}
		
	
	
	
	
	
	
	


