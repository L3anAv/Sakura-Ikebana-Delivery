//Falta Mover hacia abajo y arriba al ninja y que dispare la estrella ninja y colision con sakura

package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Ninja {
    private double x;
    private double y;
    private double alto;
    private double ancho;
    private double velocidad;
    private int direccion;
    private Image ninja;
    private double angulo;



    public Ninja(double x, double y, double velocidad,int dir){

        this.x = x;
        this.y = y;
        this.alto = 40;
        this.ancho = 25;
        this.angulo = 0;
        ninja = Herramientas.cargarImagen("ninja.png");
        this.velocidad = velocidad;
        this.direccion = dir;

    }
     	
	static void generarNinjas(Ninja[] ninjas, Entorno entorno) {
		
		for (int i=0; i<ninjas.length;i++) {
			if (ninjas[i] !=null) {
            ninjas[i].Dibujarse(entorno);   
            ninjas[i].mover();               
		    }
		}
	}
	static void respawnNinjas(Ninja[] ninjas, Entorno entorno) {
			
		for (int i = 0; i < ninjas.length; i++) { // busca si hay algun ninja nulo 
			if (ninjas[i] ==null) {   // en el caso de que si hay algun nulo reecrearlo en el mismo lugar pero mas atras
                  switch(i) {      
                  case 0: ninjas[i] = new Ninja(-500,20*29,2, 1);  
                          break;                              
                  case 1: ninjas[i] = new Ninja(1500, 20*10,2,2);  
                          break;
                  case 2: ninjas[i] = new Ninja(-500, 20*20,2, 1);             
                          break;
                  case 3: ninjas[i] = new Ninja(40*10,-500,2,3);                             
                          break;
                  case 4: ninjas[i] = new Ninja(18*10,1000,2,4);                                 
                          break;
                  case 5: ninjas[i] = new Ninja(62*10,1000,2,4);                                
                          break;           		             	
		          } 
			}                        	
		}	
	}
	
	    //Mueve el ninja
		public void mover() {
			if (this.direccion == 1) {
				moverDerecha();
			} else if (this.direccion ==2) {
				moverIzquierda();
			}else if (this.direccion ==3) {
				moverArriba();
			} else if (this.direccion == 4) {
				moverAbajo();
			} 		
		}
		//Mueve el ninja hacia la derecha en caso que corresponda
		private void moverDerecha() {
			if(this.x >= 800) {
				this.x = 0;
			}
			this.x = this.x + this.velocidad;
		}
		//Mueve el ninja hacia la izquierda enl caso que corresponda
		private void moverIzquierda() {
			if(this.x <= 0) {
				this.x = 800;
			}
			this.x = this.x - this.velocidad;
		}
		private void moverArriba() {
			if(this.y >= 800) {
				this.y = 0;
			}
			this.y = this.y + this.velocidad;
		}
		private void moverAbajo() {
			if(this.y <= 0) {
				this.y = 800;
			}
			this.y = this.y - this.velocidad;
		}		
		
	   public boolean colisionRasengan(Rasengan rasengan, Ninja ninja ) {
			double posicionSupNinja;
			double posicionInfNinja;
			double posicionIzqNinja;
			double posicionDerNinja;
			
			double posicionSuprasengan;
			double posicionInfrasengan;
			double posicionIzqrasengan;
			double posicionDerrasengan;
					
			
			posicionSupNinja = ninja.getY() - ninja.getAlto()/2;
			posicionInfNinja = ninja.getY() + ninja.getAlto()/2;
			posicionIzqNinja = ninja.getX() - ninja.getAncho()/2;
			posicionDerNinja = ninja.getX() + ninja.getAncho()/2;
				
			posicionSuprasengan = rasengan.getY() - rasengan.getRadio();
			posicionInfrasengan = rasengan.getY() + rasengan.getRadio();
			posicionIzqrasengan = rasengan.getX() - rasengan.getRadio();
			posicionDerrasengan = rasengan.getX() + rasengan.getRadio();
												
			return !(posicionSupNinja > posicionInfrasengan || posicionInfNinja < posicionSuprasengan || posicionIzqNinja > posicionDerrasengan || posicionDerNinja < posicionIzqrasengan);		

	}
		boolean colisionSakura(Sakura sakura , Ninja ninjas) {

			double posicionSupSakura;
			double posicionInfSakura;
			double posicionIzqSakura;
			double posicionDerSakura;
			
			double posicionSupNinja;
			double posicionInfNinja;
			double posicionIzqNinja;
			double posicionDerNinja;			
			
			posicionSupSakura = sakura.getY() - sakura.getAlto()/2;
			posicionInfSakura = sakura.getY() + sakura.getAlto()/2;
			posicionIzqSakura = sakura.getX() - sakura.getAncho()/2;
			posicionDerSakura = sakura.getX() + sakura.getAncho()/2;
				
			posicionSupNinja = ninjas.getY() - ninjas.getAlto()/2;
			posicionInfNinja = ninjas.getY() + ninjas.getAlto()/2;
			posicionIzqNinja = ninjas.getX() - ninjas.getAncho()/2;
			posicionDerNinja = ninjas.getX() + ninjas.getAncho()/2;
												
			return !(posicionSupSakura > posicionInfNinja || posicionInfSakura < posicionSupNinja || posicionIzqSakura > posicionDerNinja || posicionDerSakura < posicionIzqNinja);
			
		}
					    
	    //Dibuja el ninja en este caso color negro
	 	public void Dibujarse(Entorno entorno) {
	 		entorno.dibujarImagen(ninja, x, y, angulo);
		}
	 	
	 	// getters
	 	 public double getAlto() {
	 		return alto;
	 	}
	 	public double getAncho() {
	 		return ancho;
	 	}

	 	public double getVelocidad() {
	 		return this.velocidad;
	 	}
	 	public double getX() {
	 		return this.x;
	 	}
	 	public double getY() {
	 		return this.y;
	 	}

}
