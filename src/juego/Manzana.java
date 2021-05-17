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
	  private Casa casas[]; 
	  
	 //Constructor manzana
	  public Manzana(double x, double y, int alto, int ancho,double angulo, Color color){
	        this.x = x;
	        this.y = y;
	        this.alto = alto;
	        this.ancho = ancho;
	        this.angulo = angulo;
	        this.color = color;
	        casas = new Casa[3];
	        casas[0] = new Casa(x+40,y-25,40,40,0,Color.WHITE);
	        casas[1] = new Casa(x+40,y+35,40,40,0,Color.RED);
	        casas[2] = new Casa(x-30,y+35,40,40,0,Color.GREEN);
	    }
	  
	  //Función que dibuja las manzanas con las casas
	  public void dibujar(Entorno e) {

		  e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
		  
		  // Dibujar casas en la manzana.
		  for(int i = 0;i<casas.length;i++) {
			  casas[i].dibujar(e);
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
	  
	/*  Metodo para sakura: Determina si sakura esta en la casa objetivo.
	  
	public boolean entregoElPedido(Manzana[] manzanas) {
			for (int i = 0; i < manzanas.length; i++) {
				for (int j = 0; j < manzanas[i].getCasas().length; j++) {
	            
					if(manzanas[i].getCasas()[j].isEsObjetivo() && this.llegoACasa(manzanas[i].getCasas()[j])) {
	                	 return true;
	                 }
				}
			}
		}
	  */
	}

