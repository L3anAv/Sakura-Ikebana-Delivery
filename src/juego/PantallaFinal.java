package juego;

import java.awt.Color;
import entorno.Entorno;

public class PantallaFinal {
	private double x;
    private double y;
    private int alto;
    private int ancho;
    private Color colorPantalla;
    
    public PantallaFinal(){
    	this.x = 1;
    	this.y = 1;
    	this.alto = 1200;
    	this.ancho = 1900;
    	colorPantalla = Color.WHITE;
    }
    
   public void dibujarPantallaFinal(Entorno e) {
	   e.dibujarRectangulo(x, y, ancho, alto, 0, colorPantalla);
   }
}