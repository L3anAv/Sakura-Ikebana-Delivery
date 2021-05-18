package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Sakura sakura;
//	private Ramo ramo;   
	private Manzana manzana;
	private Ramo ramo;
	private Manzana manzanas[];
	private Ninja ninjas[];
	public Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N° 6 - A - A - A - V0.01", 800, 600);

		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N - Apellido1 - Apellido2 -Apellido3 - V0.01", 800, 600);
//		ramo= new Ramo(500,150,50,50,Color.blue,2);		
		sakura = new Sakura(20*20,20*10,10,10,Color.white,2);
		ramo= new Ramo(500,150,50,50,Color.blue,2);
		

		
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
		
		
		//Ninjas y su posicion
		ninjas = new Ninja[6];
		
		ninjas[0] = new Ninja(3, 20, 10, 10, 2, 1);//ninja calle 1
		
		ninjas[1] = new Ninja(800, 20*10, 10, 10,2,2 );//ninja calle 2
		
		ninjas[2] = new Ninja(3, 20*20, 10, 10, 2, 1);//ninja calle 3
		
		ninjas[3] = new Ninja(40*10, 10, 10, 10, 2,3 );//ninja calle 1,entre manzana 2 y 3
		
		ninjas[4] = new Ninja(18*10, 20*30, 10, 10, 2,4 );//ninja calle 4,entre manzana 1 y 2
		
		ninjas[5] = new Ninja(62*10, 20*30, 10, 10, 2,4 );//ninja calle 4,entre manzana 3 y 4
		
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
		sakura.movimientoRango(entorno,manzanas[0],manzanas[1],manzanas[2],manzanas[3],
				manzanas[4],manzanas[5],manzanas[6],manzanas[7], manzanas[8], manzanas[9],
				manzanas[10], manzanas[11]);

		// x , y, ancho, alto, angulo, color
		
		for(int i=0;i<manzanas.length;i++) {
			manzanas[i].dibujar(entorno);
		};
		for(int i=0;i<ninjas.length;i++) {
			ninjas[i].Dibujarse(entorno);
		};
		
		for (int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null)
			{
			
			ninjas[i].mover();
			}
		}
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
