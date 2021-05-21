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
	private int direccion; 
	private String imagen4 = "rasengan.png";
	
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
	
	public void moverDerecha(Entorno x,Manzana[] manzanas) {
		if (!(this.x+this.ancho/2>x.ancho())) {
			  this.x+=this.movimiento;			  
		} if (movimientoRangoManzanas(manzanas)) {
			this.x-=this.movimiento;	
		}

		direccion=1; // 1=derecha 
		}
	
	public void moverIzquierda(Manzana[] manzanas) {                              

		if (!(this.x-this.ancho/2<=0)) {
			this.x-=this.movimiento;
		}if (movimientoRangoManzanas(manzanas)) {
			this.x+=this.movimiento;
		}
		direccion=2; // 2 =izquierda
		}
	public void moverArriba(Manzana[] manzanas) {
		if (!(this.y-this.alto/2<0) ) {
			this.y-=this.movimiento;
		}if (movimientoRangoManzanas(manzanas)) {
			this.y+=this.movimiento;
		}
		direccion=3;   // 3=Arriba
	}
	
	public void moverAbajo(Entorno x, Manzana[] manzanas) {
		if (!(this.y+this.alto/2>x.alto())) {
			  this.y+=this.movimiento;		
		}if (movimientoRangoManzanas(manzanas)) {
			this.y-=this.movimiento;
		}
		direccion=4; // 4= abajo
	}
	
	public void movimientoRango(Entorno entorno,Manzana[] manzanas) {		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			moverDerecha(entorno, manzanas);	
		}else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))  {
			moverIzquierda(manzanas);
		}else if (entorno.estaPresionada(entorno.TECLA_ABAJO)){
			moverAbajo(entorno,manzanas);
		}else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)){
			moverArriba(manzanas);	
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
	
	public boolean colisionCasa(Casa a, int nm, Manzana manzanas[]) {
		
		if(a.equals(manzanas[nm].getCasas(0)) || a.equals(manzanas[nm].getCasas(1))) {
			
			int anchoC1 = 110;
			int altoC1 = 39;
			
			if(this.x-this.ancho/2 < a.getX()+anchoC1/2 && 
			   this.x+this.ancho/2 > a.getX()-anchoC1/2 && 
			   this.y-this.alto/2<a.getY()+altoC1/2 &&
			   this.y+this.alto/2>a.getY()-altoC1/2  ) {
				return true;
			}else {
				return false;
			}
			
		} else if(a.equals(manzanas[nm].getCasas(2))) {
			
			int anchoC2 = 40;
			int altoC2 = 70;
			
			if(this.x-this.ancho/2 < a.getX()+anchoC2/2 && 
			   this.x+this.ancho/2 > a.getX()-anchoC2/2 && 
			   this.y-this.alto/2<a.getY()+altoC2/2 &&
			   this.y+this.alto/2>a.getY()-altoC2/2 ) {
				return true;
			} else {
				return false;
			}
			
		} else if(a.equals(manzanas[nm].getCasas(3)) || a.equals(manzanas[nm].getCasas(4))) {
			
			int anchoC3 = 70;
			int altoC3 = 40;
			
			if(this.x-this.ancho/2 < a.getX()+anchoC3/2 && 
			   this.x+this.ancho/2 > a.getX()-anchoC3/2 && 
			   this.y-this.alto/2<a.getY()+altoC3/2 &&
			   this.y+this.alto/2>a.getY()-altoC3/2) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean movimientoRangoManzanas(Manzana[] manzanas) {
		int cont=0;
		for (int i=0 ; i<manzanas.length;i++) {
			if (colision(this.x+85,this.y+55,this.ancho,this.alto,manzanas[i].getX(),manzanas[i].getY(),manzanas[i].getAlto(),manzanas[i].getAncho())==true) { //modificar x e y si hay problemas de rango...
				cont+=1;
			}else {
				cont=cont+0;
			}
			}
		if (cont>0) {
			return true; 
		}else {
			return false;
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
	
	public Rasengan disparar() {
		return new Rasengan(this.x,this.y,direccion,imagen4);
	}
	
	}
	
	

	
	      

		
	
	
	
	
	
	
	


