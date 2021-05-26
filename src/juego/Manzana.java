package juego;

import java.awt.Color;
import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Manzana {
	
	  private double x;
	  private double y;
	  private int alto; 
	  private int ancho; 
	  private double angulo;
	  private Color color;
	  private Casa casas[];
	  private Image plantas;
	  
	 //Constructor manzana
	  public Manzana(double x, double y, int alto, int ancho,double angulo, Color color){
	        this.x = x;
	        this.y = y;
	        this.alto = alto;
	        this.ancho = ancho;
	        this.angulo = angulo;
	        this.color = color;

//Casas de la manzana.
	        
	        //Decalracion de arreglo de objetos Casa
	        casas = new Casa[5];
	        
	        //Posiciones del arreglo casas de objetos Casa
	        casas[0] = new Casa(x+65,y-32,0,1,false); 
	        casas[1] = new Casa(x+65,y+30,0,1,false); 
	        casas[2] = new Casa(x-35,y+49,0,2,false);
	        casas[3] = new Casa(x-75,y-32,0,3,false);
	        casas[4] = new Casa(x-75,y+30,0,3,false);
	        
	        plantas = Herramientas.cargarImagen("decoraciones.png");
	        
	    }
	  
	  //Función que dibuja las manzanas con las casas
	  public void dibujar(Entorno e) {
		  
		  //Dibujar manzana
		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);

		  //Dibujar plantas
		  e.dibujarImagen(plantas, x-42, y-35, 0);
		  e.dibujarImagen(plantas, x-42, y-15, 0);
		  e.dibujarImagen(plantas, x-25, y-15, 0);
		  
		  // Dibujar casas en la manzana
		  for(int i = 0;i<casas.length;i++) {
			  if(i != 3 && i != 4) {
				 casas[i].dibujar(e); 
			  }	  
		  }
		  

	  }
	  
	  public void dibujarEsq(Entorno e) {
		 
		  //Dibujar mazana
		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		  
		  //Dibujar plantas
		  e.dibujarImagen(plantas, x+20, y-35, 0);
		  e.dibujarImagen(plantas, x-10, y, 0);
		  e.dibujarImagen(plantas, x+40, y, 0);
		  e.dibujarImagen(plantas, x+20, y+35, 0);
		  
		  // Dibujar casas en la manzana
		  for(int i = 0;i<casas.length;i++) {
			  if(i == 3 || i == 4) {
				 casas[i].dibujar(e); 
			  }	  
		  }
	  }
	
	  public double getX() {
		  return x;
	  }

	  public double getY() {
			return y;
		}
	
	  public int getAlto() {
			return alto;
		}
	
	  public int getAncho() {
			return ancho;
		}

	  public Casa getCasas(int n) {
			return casas[n];
		}
	  
	}

