package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;
import java.util.Random;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Sakura sakura;
	private Ninja ninjas[];
	private Rasengan rasengan[];
	private Manzana manzanas[];
	private int nm;
	private Color color;
	private Casa casaObj;
	private int puntaje = 0;
	
	
	public Juego() {

		//Inicializaciones
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N 6 - Gomez - Avila - **** - V0.01", 800, 600);	
		sakura = new Sakura(20*20,20*10,0,2);
		rasengan = new Rasengan[1];
		
		//color de manzanas.
		color = Color.decode("#9adb33");
		
		//Arreglos de objetos
		manzanas = new Manzana[12];
		ninjas = new Ninja[6];
		
		//Manzanas
		manzanas[0] = new Manzana(70,60+40,120,180, 0,color);   
		manzanas[1] = new Manzana(70+220,60+40,120,180, 0,color);
		manzanas[2] = new Manzana(70+440,60+40,120,180, 0,color);
		manzanas[3] = new Manzana(70+658,60+40,120,180, 0,color); // Hasta aca las de Arriba 
		manzanas[4] = new Manzana(70,60+230,120,180, 0,color);
		manzanas[5] = new Manzana(70+220,60+230,120,180, 0,color);
		manzanas[6] = new Manzana(70+440,60+230,120,180, 0,color);
		manzanas[7] = new Manzana(70+658,60+230,120,180, 0,color); // Hasta aca de las del Medio
		manzanas[8] = new Manzana(70,60+430,120,180, 0,color);
		manzanas[9] = new Manzana(70+220,60+430,120,180, 0,color);
		manzanas[10] = new Manzana(70+440,60+430,120,180, 0,color);
		manzanas[11] = new Manzana(70+658,60+430,120,180, 0,color); // Hasta aca las de Abajo
		
		//Ninjas
		ninjas[0] = new Ninja(2, 20*29, 10, 10, 2, 1);//ninja calle 1
		ninjas[1] = new Ninja(800, 20*10, 10, 10,2,2);//ninja calle 2
		ninjas[2] = new Ninja(3, 20*20, 10, 10, 2, 1);//ninja calle 3
		ninjas[3] = new Ninja(40*10, 10, 10, 10, 2,3 );//ninja calle 1,entre manzana 2 y 3
		ninjas[4] = new Ninja(18*10, 20*30, 10, 10, 2,4 );//ninja calle 4,entre manzana 1 y 2
		ninjas[5] = new Ninja(62*10, 20*30, 10, 10, 2,4 );//ninja calle 4,entre manzana 3 y 4


		
		// Eleccion de casa objetivo y marca sobre la casa objetivo
		casaObj = elegirCasaObjetivo(manzanas);

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
		
		//Escribir en pantalla
		entorno.cambiarFont("Arial", 20, Color.WHITE);
		
		//Dibujar
		if(puntaje == 400) {
			entorno.escribirTexto("Puntaje: " + puntaje, 40, 25);
			entorno.escribirTexto("Una mas para ganar!", 220, 25);
		} else {
			entorno.escribirTexto("Puntaje: " + puntaje, 40, 25);
		}
		
		// Dibujar sakura, control de movimiento y habilidad especial de sakura	
		sakura.dibujar(entorno);
		sakura.movimientoRango(entorno,manzanas);
		sakura.habilidadEspecialRasengan(entorno,manzanas, rasengan, ninjas);
	
		//Dibujar manzanas en entorno segun si es 3, 7, 11
		for(int i=0;i<manzanas.length;i++) {
			if(i != 3 && i != 7 && i != 11) {
			manzanas[i].dibujar(entorno);
			} else {
				manzanas[i].dibujarEsq(entorno);
			}
		};

		
		//Dibujar ninjas
		for (int i = 0; i < ninjas.length; i++) {
			if(ninjas[i] != null){
            ninjas[i].Dibujarse(entorno);
            ninjas[i].mover();
            }
		}
		
		
		// Condicinal para colision de sakura con casaObj
		if(sakura.colisionCasa(casaObj)) {
			casaObj.setCasaObjetivo(false);
			casaObj = elegirCasaObjetivo(manzanas);
			casaObj.setCasaObjetivo(true);
			puntaje = puntaje + 100; 
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

		
		//Colision Rasengan(Verificacion)	
		for (int i = 0; i < ninjas.length; i++) {
			
            if(ninjas[i]!=null && rasengan[0]!=null) {
                    if(ninjas[i].colisionRasengan(rasengan[0],ninjas[i])==true) {

                        rasengan[0]=null;
                        ninjas[i]=null;
           
                    }
            } 
		}
		
		
		//Verificacion de colsion Ninja Sakura
			for (int i = 0; i < ninjas.length; i++) {
				if(ninjas[i]!=null && sakura!=null) {
					if(ninjas[i].colisionSakura(sakura,ninjas[i])==true) {
						entorno.dispose();
					}
				}
			}
		
		if(puntaje >= 500) {
			 entorno.dispose();
		}
		
	}
	
	//Retorna la casaObj ademas de cambiar el valor de la variable casaObjtivo en casa a true.
	public Casa elegirCasaObjetivo(Manzana manzanas[]) {
		//Eleccion de manzana random
		Random manzanaObjetivo = new Random();
		nm = manzanaObjetivo.nextInt(12);
			
		//Eleccion de casaObjetivo condicionando != 3 7 11
		if(nm != 3 && nm != 7 && nm != 11) {
			Random casaObjetivo = new Random();
			int co = casaObjetivo.nextInt(3);
			
			//Fijado de casaObtivo == true en la casa random elegida
			manzanas[nm].getCasas(co).setCasaObjetivo(true);
				
			//Retorno de casaObjetivo
			return casaObj = manzanas[nm].getCasas(co);
				
		} else {
			Random casaObjetivo = new Random();
			int co = 0;
			int ran = casaObjetivo.nextInt(2) + 1;
			if(ran == 1) {
				co = 3;
			} else {
				co = 4;
		}
		
		//Fijado de casaObtivo == true en la casa random elegida
		manzanas[nm].getCasas(co).setCasaObjetivo(true);
		
		//Retorno de casaObjetivo
		return casaObj = manzanas[nm].getCasas(co);
         }
	} 
		         
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}

//
