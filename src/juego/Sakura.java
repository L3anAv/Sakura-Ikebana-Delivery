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
	public void moverDerecha(Entorno x,Manzana a,Manzana b, Manzana c, Manzana d, Manzana e, Manzana f, Manzana g,Manzana h, Manzana i
			,Manzana j, Manzana k,Manzana l) {
		if (!(this.x+this.ancho/2==x.ancho())) {
			  this.x+=this.movimiento;			  
		} if (movimientoRangoManzanas(a,b,c,d,e,f,g,h,i,j,k,l)) {
			this.x-=this.movimiento;
		}
		
	}
	public void moverIzquierda(Manzana a,Manzana b, Manzana c, Manzana d, Manzana e, Manzana f, Manzana g,Manzana h, Manzana i,
			Manzana j, Manzana k,Manzana l) {                              
		if (!(this.x-this.ancho/2<=0)) {
			this.x-=this.movimiento;
		}if (movimientoRangoManzanas(a,b,c,d,e,f,g,h,i,j,k,l)) {
			this.x+=this.movimiento;
		}		
		}	
	public void moverArriba(Manzana a,Manzana b, Manzana c, Manzana d, Manzana e, Manzana f, Manzana g,Manzana h, Manzana i,
			Manzana j, Manzana k,Manzana l) {
		if (!(this.y-this.alto/2<0) ) {
			this.y-=this.movimiento;
		}if (movimientoRangoManzanas(a,b,c,d,e,f,g,h,i,j,k,l)) {
			this.y+=this.movimiento;
		}	
	}
	public void moverAbajo(Entorno x, Manzana a,Manzana b, Manzana c, Manzana d, Manzana e, Manzana f, Manzana g,Manzana h, Manzana i,
			Manzana j, Manzana k,Manzana l) {
		if (!(this.y+this.alto/2>x.alto())) {
			  this.y+=this.movimiento;		
		}if (movimientoRangoManzanas(a,b,c,d,e,f,g,h,i,j,k,l)) {
			this.y-=this.movimiento;
		}		
	}		
	public void movimientoRango(Entorno entorno,Manzana a,Manzana b,Manzana c, Manzana d, Manzana e, Manzana f, Manzana g, Manzana h, Manzana i,Manzana j, Manzana k,
			Manzana l) {		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			moverDerecha(entorno,a,b,c,d,e,f,g,h,i,j,k,l);	
		}else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))  {
			moverIzquierda(a,b,c,d,e,f,g,h,i,j,k,l);
		}else if (entorno.estaPresionada(entorno.TECLA_ABAJO)){
			moverAbajo(entorno,a,b,c,d,e,f,g,h,i,j,k,l);
		}else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)){
			moverArriba(a,b,c,d,e,f,g,h,i,j,k,l);	
		}
	}
	public static boolean colision(double x1, double y1, double anchoX, double altoX,double x2, double y2,double altoY, double anchoY) {    //------ pensado para dos cuadrados-------
		 if (x1<x2+anchoY  &&  x1+anchoX>x2 && y1 < y2+altoY && y1+altoX >y2) {
			 return true;
		 }else {
		return false;
		 }
	}
	public  boolean colision1(Manzana a) {
		boolean l= this.y-this.alto/2< a.getY()+a.getAlto()/2 &&
				this.x+this.ancho/2 > a.getX()-a.getAncho()/2 &&
				this.y+this.alto/2 > a.getY()-a.getAlto()/2 &&
				this.x-this.ancho/2< a.getY()+a.getAncho()/2;
				
		return l;
	}
	public boolean movimientoRangoManzanas(Manzana a,Manzana b, Manzana c, Manzana d, Manzana e, Manzana f, Manzana g,Manzana h, Manzana i, Manzana j, Manzana k,
			Manzana l) {
		if(colision(this.x+85,this.y+55,this.ancho,this.alto,a.getX(),a.getY(),a.getAlto(),a.getAncho())==true ||
		colision(this.x+85,this.y+55,this.ancho,this.alto,b.getX(),b.getY(),b.getAlto(),b.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,c.getX(),c.getY(),c.getAlto(),c.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,d.getX(),d.getY(),d.getAlto(),d.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,e.getX(),e.getY(),e.getAlto(),e.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,f.getX(),f.getY(),f.getAlto(),f.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,g.getX(),g.getY(),g.getAlto(),g.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,h.getX(),h.getY(),h.getAlto(),h.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,i.getX(),i.getY(),i.getAlto(),i.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,j.getX(),j.getY(),j.getAlto(),j.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,k.getX(),k.getY(),k.getAlto(),k.getAncho())==true
		||colision(this.x+85,this.y+55,this.ancho,this.alto,l.getX(),l.getY(),l.getAlto(),l.getAncho())==true
		) {
			return true;
		}else { return false;
			
		}
		
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
	}
	
	

	
	      

		
	
	
	
	
	
	
	


