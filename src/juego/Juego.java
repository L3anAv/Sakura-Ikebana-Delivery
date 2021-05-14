package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.awt.Color;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Manzana manzana;
	
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N° 6 - A - A - A - V0.01", 800, 600);
		
		// Inicializar lo que haga falta para el juego.
		
		// X - Y - ancho - alto - angulo - color.
		// x tiene que ser la mitad del ancho del rectangulo.
		// y tiene que ser la mitad del alto del rectangulo.
		manzana = new Manzana(90+20,60+20,120,180, 0,Color.BLUE);
		
		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		
		// Procesamiento de un instante de tiempo
		// x , y, ancho, alto, angulo, color
		
		
		manzana.dibujar(entorno);
		
		//entorno.dibujarRectangulo(90+20,60+20, 180, 120, 0,Color.BLUE);
		
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
