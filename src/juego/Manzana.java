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
	  private String imagen1 = "casita-1-larga2.png";
	  private String imagen2 = "casita-2-chiquita.png";
	  private String imagen3 = "casa-3-chiquita-izq.png";
	  private Image plantitas;
	  
	 //Constructor manzana
	  public Manzana(double x, double y, int alto, int ancho,double angulo, Color color){
	        this.x = x;
	        this.y = y;
	        this.alto = alto;
	        this.ancho = ancho;
	        this.angulo = angulo;
	        this.color = color;
	        
	        casas = new Casa[5];
	        /*
	        casas[0] = new Casa(x+40,y-25,40,40,0,Color.BLUE,false);
	        casas[1] = new Casa(x+40,y+35,40,40,0,Color.RED,false);
	        casas[2] = new Casa(x-30,y+35,40,40,0,Color.CYAN,false);
	    	*/
	        
	        casas[0] = new Casa(x+65,y-32,0,false,imagen1); 
	        casas[1] = new Casa(x+65,y+30,0,false,imagen1); 
	        casas[2] = new Casa(x-35,y+47,0,false,imagen2);
	        
	        casas[3] = new Casa(x-75,y-32,0,false,imagen3);
	        casas[4] = new Casa(x-75,y+30,0,false,imagen3);
	        
	        plantitas = Herramientas.cargarImagen("decoraciones.png");
	        
	    }
	  
	  //Función que dibuja las manzanas con las casas
	  public void dibujar(Entorno e) {

		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		  
		  e.dibujarImagen(plantitas, x-42, y-35, 0);
		  e.dibujarImagen(plantitas, x-42, y-15, 0);
		  e.dibujarImagen(plantitas, x-25, y-15, 0);
		  
		  // Dibujar casas en la manzana.
		  for(int i = 0;i<casas.length;i++) {
			  if(i != 3 && i != 4) {
				 casas[i].dibujar(e); 
			  }	  
		  }
		  
	  }
	  
	  public void dibujarEsq(Entorno e) {
		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		  
		  e.dibujarImagen(plantitas, x+20, y-35, 0);
		  e.dibujarImagen(plantitas, x-10, y, 0);
		  e.dibujarImagen(plantitas, x+40, y, 0);
		  e.dibujarImagen(plantitas, x+20, y+35, 0);
		  
		  // Dibujar casas en la manzana.
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
			Casa casa = casas[n];
			return casa;
		}

	
	}

