package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;
import java.awt.Color;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
<<<<<<< HEAD
=======
	private Sakura sakura;
	private Ramo ramo;   
	private Manzana manzana;
>>>>>>> 296151a2211c113b9f2ea138950563cffb3fab70
	private Manzana manzanas[];

	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N° 6 - A - A - A - V0.01", 800, 600);
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N - Apellido1 - Apellido2 -Apellido3 - V0.01", 800, 600);
		ramo= new Ramo(500,150,50,50,Color.blue,2);		
		sakura = new Sakura(entorno.ancho()/2,entorno.alto()/2,50,50,Color.white,2);
		
		// Inicializar lo que haga falta para el juego.
		// X - Y - ancho - alto - angulo - color.
		// x tiene que ser la mitad del ancho del rectangulo.
		// y tiene que ser la mitad del alto del rectangulo.
		manzanas = new Manzana[12];
		// Arriba
		manzanas[0] = new Manzana(70,60+40,120,180, 0,Color.BLUE);
		manzanas[1] = new Manzana(70+220,60+40,120,180, 0,Color.BLUE);
		manzanas[2] = new Manzana(70+440,60+40,120,180, 0,Color.BLUE);
		manzanas[3] = new Manzana(70+658,60+40,120,180, 0,Color.BLUE);
		
		// Centro
		manzanas[4] = new Manzana(70,60+230,120,180, 0,Color.BLUE);
		manzanas[5] = new Manzana(70+220,60+230,120,180, 0,Color.BLUE);
		manzanas[6] = new Manzana(70+440,60+230,120,180, 0,Color.BLUE);
		manzanas[7] = new Manzana(70+658,60+230,120,180, 0,Color.BLUE);
		// Abajo
		manzanas[8] = new Manzana(70,60+430,120,180, 0,Color.BLUE);
		manzanas[9] = new Manzana(70+220,60+430,120,180, 0,Color.BLUE);
		manzanas[10] = new Manzana(70+440,60+430,120,180, 0,Color.BLUE);
		manzanas[11] = new Manzana(70+658,60+430,120,180, 0,Color.BLUE);
		
		
		

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

		// ...
		sakura.dibujar(entorno);
		sakura.movimiento(entorno,ramo);
		ramo.dibujar(entorno);


		// x , y, ancho, alto, angulo, color
		
		for(int i=0;i<manzanas.length;i++) {
			manzanas[i].dibujar(entorno);
		};
		
		

		

	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
