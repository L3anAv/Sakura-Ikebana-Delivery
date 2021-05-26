package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;


public class Rasengan {
	private double x;
	private double y;
	private double radio;
	private double velocidad;
	private int direccion;	
	private Image imagen4;
	
	
	public Rasengan(double x, double y,int dir,String imagen) {
		this.x = x;
		this.y = y;
		this.radio = 1;
		this.velocidad = 5;
		this.direccion = dir;
		imagen4 = Herramientas.cargarImagen(imagen);
	}
	

	//---Movimiento del Rasengan----
	public void mover() {
		 if(this.direccion == 0 ) {	 		
			moverDerecha();
		} else if (this.direccion == 1) {
			moverDerecha();	
		} else if (this.direccion ==2) {
			moverIzquierda();
		}else if (this.direccion == 3) {
			moverAbajo();
		} else if (this.direccion == 4) {
			moverArriba();			
		} 
	}
	
	private void moverDerecha() {
		if(this.x >= 800) { 
			this.x = 0;
		}
		this.x+=this.velocidad;  
	}
	
	private void moverIzquierda() {
		if(this.x <= 0) {
			this.x = 800;
		}
		this.x-=this.velocidad; 
	}
	
	private void moverArriba() {
		if(this.y >= 800) {
			this.y = 0;
		}
		this.y+=this.velocidad; 
	}
	
	private void moverAbajo() {
		if(this.y <= 0) {
			this.y = 800;
		}
		this.y-=this.velocidad; 
	}
	
	//---- Colision y rango de movimiento ----
	
	private boolean  movimientoRangoManzasRasengan(Manzana[] manzanas, Rasengan rasengan) {
		int cont=0;
		for (int i=0 ; i<manzanas.length;i++) {
			if (colisionRasenganManzana(rasengan, manzanas[i])==true) { 
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
 
	private boolean colisionRasenganManzana(Rasengan rasengan, Manzana manzana ) {
		double posicionSupManzana;
		double posicionInfManzana;
		double posicionIzqManzana;
		double posicionDerManzana;
		
		double posicionSuprasengan;
		double posicionInfrasengan;
		double posicionIzqrasengan;
		double posicionDerrasengan;
				
		
		posicionSupManzana = manzana.getY() - manzana.getAlto()/2;
		posicionInfManzana = manzana.getY() + manzana.getAlto()/2;
		posicionIzqManzana = manzana.getX() - manzana.getAncho()/2;
		posicionDerManzana = manzana.getX() + manzana.getAncho()/2;
			
		posicionSuprasengan = rasengan.getY() - rasengan.getRadio();
		posicionInfrasengan = rasengan.getY() + rasengan.getRadio();
		posicionIzqrasengan = rasengan.getX() - rasengan.getRadio();
		posicionDerrasengan = rasengan.getX() + rasengan.getRadio();
											
		return !(posicionSupManzana > posicionInfrasengan || posicionInfManzana < posicionSuprasengan || posicionIzqManzana > posicionDerrasengan || posicionDerManzana < posicionIzqrasengan);		
    }
	
	public void rangoRasengan(Manzana[] manzanas, Rasengan[] rasengan, int i, Entorno entorno ) {
		if(rasengan[i].getX() <= 0 || rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i]) ) 
		{
			rasengan[i] = null;  
		}
		else if(rasengan[i].getX()  >= entorno.ancho()|| rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
		{
			rasengan[i] = null; 
		}
		else if(rasengan[i].getY() <= 0 || rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
		{
			rasengan[i] = null; 
		}
		else if(rasengan[i].getY()  >= entorno.alto()|| rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
		{
			rasengan[i] = null;  
		}
	}
	

	//Dibuja Rasengan
	public void Dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen4, x, y, radio); 
		}
	
	// getters
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getRadio() {
		return radio;
	}
	
}
