package juego;

import java.awt.Color;

import entorno.Entorno;

public class Manzana {
	  private double x;
	  private double y;
	  private int alto; //fijo
	  private int ancho; //fijo
	  private double angulo;
	  private Color color;
	  
	 //Constructor manzana
	  public Manzana(double x, double y, int alto, int ancho,double angulo, Color color){
	        this.x = x;
	        this.y = y;
	        this.alto = alto;
	        this.ancho = ancho;
	        this.angulo = angulo;
	        this.color = color;
	    }
	  
	  //Función que dibuja las manzanas con las casas
	  public void dibujar(Entorno e) {

		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		  
		  //Array de casas
		  Casa casas[] ={ new Casa(x+40,y-25,40,40,0,Color.WHITE),
				  		  new Casa(x+40,y+35,40,40,0,Color.RED),
				  		  new Casa(x-30,y+35,40,40,0,Color.GREEN)};
		  
		  // Dibujar casas en la manzana.
		  for(int i = 0;i<casas.length;i++) {
			  casas[i].dibujar(e);
		  }
	  }
	  
	}

