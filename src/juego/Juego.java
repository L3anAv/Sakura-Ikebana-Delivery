package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.awt.Color;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Manzana manzana;
	private Manzana manzanas[];
	
	
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N° 6 - A - A - A - V0.01", 800, 600);
		
		// Inicializar lo que haga falta para el juego.
		
		// X - Y - ancho - alto - angulo - color.
		// x tiene que ser la mitad del ancho del rectangulo.
		// y tiene que ser la mitad del alto del rectangulo.
		// new Manzana(90+20,60+20,120,180, 0,Color.BLUE)
		manzanas = new Manzana[9];
		// Arriba
		manzanas[0] = new Manzana(110+20,60+20,120,180, 0,Color.BLUE);
		manzanas[1] = new Manzana(330+20,60+20,120,180, 0,Color.BLUE);
		manzanas[2] = new Manzana(550+20,60+20,120,180, 0,Color.BLUE);
		// Centro
		manzanas[3] = new Manzana(110+20,260+20,120,180, 0,Color.BLUE);
		manzanas[4] = new Manzana(330+20,260+20,120,180, 0,Color.BLUE);
		manzanas[5] = new Manzana(550+20,260+20,120,180, 0,Color.BLUE);
		// Abajo
		manzanas[6] = new Manzana(110+20,480+20,120,180, 0,Color.BLUE);
		manzanas[7] = new Manzana(330+20,480+20,120,180, 0,Color.BLUE);
		manzanas[8] = new Manzana(550+20,480+20,120,180, 0,Color.BLUE);
		
		
		
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
		
		for(int i=0;i<manzanas.length;i++) {
			manzanas[i].dibujar(entorno);
		};
		//manzanas[0].dibujar(entorno);
		//manzanas[1].dibujar(entorno);
		//entorno.dibujarRectangulo(90+20,60+20, 180, 120, 0,Color.BLUE);
		
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
