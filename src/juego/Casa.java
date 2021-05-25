package juego;

//import java.awt.Color;
import entorno.Entorno;

import java.awt.Image;
import entorno.Herramientas;


public class Casa {
	
	private double x;
	  private double y;
	  private int alto; 
	  private int ancho;
	  private int tipo;
	  private double angulo;
	  private Image casa;
	  private Marca marca;
	  private String casa1 = "casita-1-larga2.png";
	  private String casa2 = "casita-2-chiquita.png";
	  private String casa3 = "casa-3-chiquita-izq.png";
	  private boolean casaObjetivo;
	  
	 
	 
	public Casa(double x, double y, double angulo,int tipo, boolean casaObjetivo) {
		
		this.x = x;
		this.y = y;
		this.casaObjetivo = false;
		this.angulo = 0;
		this.tipo = tipo;
		
		// Fijado de ancho y alto, segun casa
		if(this.tipo == 1) {
			 this.ancho = 110;
			 this.alto = 39; 
		} else if(this.tipo == 2) {
			this.alto = 80;
			this.ancho = 40;
		} else if(this.tipo == 3) {
			this.alto = 40;
			this.ancho = 70;
		}
		
		//Imagen segun tipo de casa
		if(this.tipo == 1) {
		casa = Herramientas.cargarImagen(casa1);
		} else if(this.tipo == 2) {
			casa = Herramientas.cargarImagen(casa2);
		} else if(this.tipo == 3) {
			casa = Herramientas.cargarImagen(casa3);
		}
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(casa, x, y, angulo);
		
		//condicional para dibujar marca en casaObj
		//Falta Imagen flechita
		if(casaObjetivo == true && this.tipo == 1) {
			marca = new Marca(x-10,y,-33);
			marca.dibujarMarca(e);
		} else if(casaObjetivo == true && this.tipo == 2) {
			marca = new Marca(x-1,y-13,0);
			marca.dibujarMarca(e);
		} else if(casaObjetivo == true && this.tipo == 3) {
			marca = new Marca(x+13,y,33);
			marca.dibujarMarca(e);
		}
		
	}
	
	public boolean isCasaObjetivo() {
		return casaObjetivo;
	}

	public void setCasaObjetivo(boolean casaObjetivo) {
		this.casaObjetivo = casaObjetivo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public double getX() {
		return x;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public double getY() {
		return y;
	}

	
	
	  
}
