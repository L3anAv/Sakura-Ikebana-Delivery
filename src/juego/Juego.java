package juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;
import java.util.Random;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private PantallaFinal Pfinal;
	private Sakura sakura;
	private Ninja ninjas[];
	private Rasengan rasengan[];
	private Manzana manzanas[];
	private int nm;
	private Color color;
	private Casa casaObj;
	private int puntaje = 0;
	
	public Juego() {

//Declaracion de entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N 6 - Gomez - Avila - **** - V0.01", 800, 600);	
		
//Inicializacion de objetos
		
		//Creacion de objetos
		Pfinal = new PantallaFinal();
		sakura = new Sakura(20*20,20*10,0,2);
		rasengan = new Rasengan[1];

//Declarando los arreglos de objetos
		
		//Arreglos de objetos
		manzanas = new Manzana[12];
	 	ninjas = new Ninja[7];
	 	
//Variable de color en hexadecimal
	 	
	 	//Color de manzanas
	 	color = Color.decode("#9adb33");
	 	
//Declarando cada posiciÃ³n de los arreglos de objetos	
	 	
		//Posiciones de arreglo Manzanas
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
		
		//Posiciones de arreglo Ninjas  
		ninjas[0] = new Ninja(0, 20*29, 2, 1);//ninja calle abajo
		ninjas[1] = new Ninja(800, 20*10,2,2);//ninja calle 2
		ninjas[2] = new Ninja(0, 20*20, 2 , 1);//ninja calle 3
		ninjas[3] = new Ninja(40*10,40,2,3 );//ninja calle 1,entre manzana 2 y 3
		ninjas[4] = new Ninja(18*10,20*30,2,4 );//ninja calle 4,entre manzana 1 y 2 -- este
		ninjas[5] = new Ninja(62*10,20*30,2,4 );//ninja calle 4,entre manzana 3 y 4
		ninjas[6] = new Ninja (0,0,0,0); // Ninja base invisible

//Primer eleccion de casaObj	
		
		// Eleccion de casa objetivo
		casaObj = elegirCasaObjetivo(manzanas);
		
//Inicio de juego
		
		// Inicia el juego!
		
		this.entorno.iniciar();
	}
		
	public void tick() {

//Texto en entornoR
		
		//Seteo del tamaÃ±o, color y tipo de Font.
		entorno.cambiarFont("Arial", 20, Color.WHITE);   
		
		//Dibujar en pantalla segÃºn puntaje.
		//Aviso de cuando le falta 1 entrega para ganar!
		if(puntaje >= 15) {    
			entorno.escribirTexto("Puntaje: " + puntaje, 35, 25);
			entorno.escribirTexto("Ninjas eliminados: " + sakura.getcontNinjaElim(), 575, 25);
			entorno.escribirTexto("¡Una entrega mas para ganar!", 210, 25);
		} else {   
			entorno.escribirTexto("Puntaje: " + puntaje, 35, 25);
			entorno.escribirTexto("Ninjas eliminados: " + sakura.getcontNinjaElim(), 575, 25);
		}
				
//Dibujadores
		
		// Dibujar sakura, control de movimiento y habilidad especial de sakura	
		// Procesamiento de un instante de tiempo
		sakura.dibujar(entorno);
		sakura.movimientoRango(entorno,manzanas);
		sakura.habilidadEspecialRasengan(entorno,manzanas, rasengan, ninjas);
		
		//Dibujar manzanas en entorno segun si es 3, 7 o 11 || si es 3, 7 o 11 le dibuja 2 casas 
		for(int i=0;i<manzanas.length;i++) {
			if(i != 3 && i != 7 && i != 11) {
			manzanas[i].dibujar(entorno);
			} else {
				manzanas[i].dibujarEsq(entorno);
			}
		}
		
	
		// dibujo y respawneo de ninjas
		ninjas[6].respawnNinjas(ninjas, entorno);
		
		
//Colisiones
		
		// Condicinal para colision de sakura con casaObj
		//Asignacion de puntos por llegada a casaObj y Reseteo de casaObj
		if(sakura.colisionCasa(casaObj)) {
			casaObj.setCasaObjetivo(false); 
			casaObj = elegirCasaObjetivo(manzanas); 
			casaObj.setCasaObjetivo(true);   
			puntaje = puntaje + 5;  
		}
		 
		//Verificacion de colsion Ninja Sakura
		//Si colisiona, se cierra el juego.
			for (int i = 0; i < ninjas.length; i++) { 
				if(ninjas[i]!=null && sakura!=null)  { 
					if(ninjas[i].colisionSakura(sakura,ninjas[i])==true) { 
						entorno.dispose();    
					}
			     }
			}
			
//Pantalla Final Victoria
			
		//Verificacion si puntaje >= 20
		//Dibuja la pantalla de Ganaste el juego!
		if(puntaje >= 20) { 
			Pfinal.dibujarPantallaFinal(entorno);
			entorno.cambiarFont("Arial", 40, Color.BLACK);   
			entorno.escribirTexto("¡Ganaste el juego!", 220, 300);  
		}	
}
	

//Metodo de seleccion aleatoria de casaObj
	
	//Retorna la casaObj 
	//Ademas de cambiar el valor de la variable casaObjtivo en Casa a true.
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
		
		//Fijado de casaObjetivo == true en la casa random elegida
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
