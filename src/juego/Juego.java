package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;
import java.util.Random;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Sakura sakura; 
//	private Ramo ramo;
	private Manzana manzanas[];
	private Color color;
	private Ninja ninjas[];
	private Rasengan rasengan[];

	public Juego() {

		//Inicializaciones
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N - Apellido1 - Apellido2 -Apellido3 - V0.01", 800, 600);
//		ramo= new Ramo(500,150,50,50,Color.blue,2);		
		sakura = new Sakura(20*20,20*10,10,10,Color.white,2);
//		ramo= new Ramo(500,150,50,50,Color.blue,2);
		rasengan = new Rasengan[3];

		//color de manzanas.
		color = Color.decode("#9adb33");
		
		//Arreglo de manzanas.
		manzanas = new Manzana[12];
		
		// Arriba
		manzanas[0] = new Manzana(70,60+40,120,180, 0,color);
		manzanas[1] = new Manzana(70+220,60+40,120,180, 0,color);
		manzanas[2] = new Manzana(70+440,60+40,120,180, 0,color);
		manzanas[3] = new Manzana(70+658,60+40,120,180, 0,color);
		// Centro
		manzanas[4] = new Manzana(70,60+230,120,180, 0,color);
		manzanas[5] = new Manzana(70+220,60+230,120,180, 0,color);
		manzanas[6] = new Manzana(70+440,60+230,120,180, 0,color);
		manzanas[7] = new Manzana(70+658,60+230,120,180, 0,color);
		// Abajo
		manzanas[8] = new Manzana(70,60+430,120,180, 0,color);
		manzanas[9] = new Manzana(70+220,60+430,120,180, 0,color);
		manzanas[10] = new Manzana(70+440,60+430,120,180, 0,color);
		manzanas[11] = new Manzana(70+658,60+430,120,180, 0,color);
		
		//Eleccion de manzanaObjetivo
		Random manzanaObjetivo = new Random();
		int nm = manzanaObjetivo.nextInt(12);
		
		//Manzana elegida
		//System.out.println(nm);
		
		//Eleccion de casaObjetivo condicionando si es esquina o no != 3 7 11
		if(nm != 3 && nm != 7 && nm != 11) {
			Random casaObjetivo = new Random();
			int co = casaObjetivo.nextInt(3);
			
			//System.out.println(co);
			manzanas[nm].getCasas(co).setCasaObjetivo(true);
			
		} else {
			Random casaObjetivo = new Random();
			int co = 0;
			int ran = casaObjetivo.nextInt(2) + 1;
			if(ran == 1) {
				co = 3;
			} else {
				co = 4;
			}
			
			//Casa elegida
			//System.out.println(co);
			
			manzanas[nm].getCasas(co).setCasaObjetivo(true);
		}
		
		//Comprobacion de casaObjetivo == true
		
		//System.out.println(manzanas[nm].getCasas(0).getCasaobjetivo());
		//System.out.println(manzanas[nm].getCasas(1).getCasaobjetivo());
		//System.out.println(manzanas[nm].getCasas(2).getCasaobjetivo());
		//System.out.println(manzanas[nm].getCasas(3).getCasaobjetivo());
		//System.out.println(manzanas[nm].getCasas(4).getCasaobjetivo());
		
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

	public Manzana[] getManzanas() {
		return manzanas;
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
		
		sakura.movimientoRango(entorno,manzanas);
	

		// x , y, ancho, alto, angulo, color
		// 3 7 11
		for(int i=0;i<manzanas.length;i++) {
			if(i != 3 && i != 7 && i != 11) {
			manzanas[i].dibujar(entorno);
			} else {
				manzanas[i].dibujarEsq(entorno);
			}
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
		
		//Dispara el kamehameha enl caso de tocar la barra espaciadora solo 3 veces
		if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {

			boolean dispararRasengan = false;
			for (int i = 0; i < rasengan.length && !dispararRasengan; i++) {
				if (rasengan[i] == null) 
				{
					rasengan[i] = this.sakura.disparar();
					dispararRasengan = true;
				}
			}
		}
		//dibuja el kamehameha y desaparece segun los limites en X e Y
		for (int i = 0; i < rasengan.length; i++) {
			if (rasengan[i] != null) {
				rasengan[i].mover();
				rasengan[i].Dibujar(entorno);
				
				if(rasengan[i].getX() <= 0 ) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getX()  >= 800) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getY() <= 0 ) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getY()  >= 800) 
				{
					rasengan[i] = null;
				}
			}
		}
		
		
		
		
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}

//
