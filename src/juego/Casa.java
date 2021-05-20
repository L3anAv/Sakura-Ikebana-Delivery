package juego;

//import java.awt.Color;
import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Casa {
	private double x;
	  private double y;
	  //private int alto; 
	  //private int ancho; 
	  private double angulo;
	  private Image imagen1;
	  private boolean casaObjetivo;
	  //private Color color;

	/*
	// Constructor casa
	public Casa(double x, double y, int alto, int ancho, double angulo, Color color, boolean casaObjetivo) {
		super();
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.angulo = angulo;
		this.color = color;
		this.casaObjetivo = false;
	}
	 */
	 
	public Casa(double x, double y, double angulo, boolean casaObjetivo, String imagen) {
		this.x = x;
		this.y = y;
		this.casaObjetivo = false;
		this.angulo = angulo;
		imagen1 = Herramientas.cargarImagen(imagen);
	}
	
	/*
	// Dibujador de casa
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, alto, angulo, color);
	}
	*/
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(imagen1, x, y, angulo);
	}
	
	public boolean isCasaObjetivo() {
		return casaObjetivo;
	}

	public void setCasaObjetivo(boolean casaObjetivo) {
		this.casaObjetivo = casaObjetivo;
	}
	
	public boolean getCasaobjetivo() {
		return casaObjetivo;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	
	
	  
}
