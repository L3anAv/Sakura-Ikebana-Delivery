package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Marca {

	private double x;
	private double y;
	private double angulo;
	private Image arrow;
	
	public Marca(double x, double y, double angulo) {
		this.x = x;
		this.y= y;
		this.angulo = angulo;
		arrow = Herramientas.cargarImagen("arrow.png");
	}
	
	public void dibujarMarca(Entorno e) {
		e.dibujarImagen(arrow, x, y, angulo);
	}
}
