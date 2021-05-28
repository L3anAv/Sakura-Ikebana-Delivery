package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Sakura {
	
	private double x;
	private double y;
	private double angulo;
	private double movimiento;
	private int ancho;
	private int alto;
	private int direccion;
	private Image sakura;
	private String imagen4 = "rasengan.png";
	private Image ramo;
	
	// constructor
	public Sakura(double x, double y, double angulo,double movimiento) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		ramo= Herramientas.cargarImagen("flores.png");
		sakura = Herramientas.cargarImagen("sakura-chibi.png");
		this.alto=10;
		this.ancho=15;
		this.movimiento=movimiento;
	}
	// ---- dibujar sakura ----
	
	public void dibujar (Entorno e) {

		e.dibujarImagen(sakura, x, y, angulo); 
		e.dibujarImagen(ramo, x-20, y+5, 6);  
	}
	
	// ---- movimiento de sakura y limites ----
	private void moverDerecha(Entorno x,Manzana[] manzanas) {
		if (!(this.x+10+this.ancho/2>x.ancho())) {  
			  this.x+=this.movimiento;			  
		} if (movimientoRangoManzanas(manzanas)) { 
			this.x-=this.movimiento;	
		}
		direccion=1;     
		}
	private void moverIzquierda(Manzana[] manzanas) {                              
		if (!(this.x+1-this.ancho<=0)) {  
			this.x-=this.movimiento;     
		}if (movimientoRangoManzanas(manzanas)) {  
			this.x+=this.movimiento;
		}
		direccion=2; 
		}
	private void moverArriba(Manzana[] manzanas) {
		if (!(this.y-50-this.alto<0) ) {   // 
			this.y-=this.movimiento;
		}if (movimientoRangoManzanas(manzanas)) {  
			this.y+=this.movimiento;
		}
		direccion=3;   
	}
	private void moverAbajo(Entorno x, Manzana[] manzanas) {
		if (!(this.y+12+this.alto>x.alto())) {   
			  this.y+=this.movimiento;		
		}if (movimientoRangoManzanas(manzanas)) {  
			this.y-=this.movimiento;
		}
		direccion=4; 
	}
	public void movimientoRango(Entorno entorno,Manzana[] manzanas) {
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) { 
			moverDerecha(entorno, manzanas);	 
		}else if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))  {
			moverIzquierda(manzanas);    
		}else if (entorno.estaPresionada(entorno.TECLA_ABAJO)){
			moverAbajo(entorno,manzanas);  
		}else if (entorno.estaPresionada(entorno.TECLA_ARRIBA)){
			moverArriba(manzanas);				 
		}
	}	
	private boolean movimientoRangoManzanas(Manzana[] manzanas) {
		int cont=0;
		for (int i=0 ; i<manzanas.length;i++) {
			if (colision(this.x+90,this.y+70,this.ancho,this.alto,manzanas[i].getX(),manzanas[i].getY(),manzanas[i].getAlto()+28,manzanas[i].getAncho()+15)==true) { 
				cont+=1;   
			}else {
				cont=cont+0;
			}
	    }
		if (cont>0) {  
			return true; 
		}else {
			return false; 
		}

       }
	
	// ---- metodo colisones ----   

	private  boolean colision(double x1, double y1, double anchoX, double altoX,double x2, double y2,double altoY, double anchoY) {    
		 if (x1<x2+anchoY  &&  x1+anchoX>x2 && y1 < y2+altoY && y1+altoX >y2) {
			 return true;
		 }else {
		return false;
		 }
	}	 
    public boolean colisionCasa(Casa a) {

        if(a.getTipo() == 1) { 

            if(this.x-this.ancho/2 < a.getX()+a.getAncho()/2 && 
               this.x+this.ancho/2 > a.getX()-a.getAncho()/2 &&  
               this.y-this.alto/2<a.getY()+a.getAlto()/2 &&     
               this.y+this.alto/2>a.getY()-a.getAlto()/2) {     
                return true;
            }else {
                return false;
            }

        } else if(a.getTipo() == 2) { 

        	
            if(this.x-this.ancho/2 < a.getX()+a.getAncho()/2 && 
               this.x+this.ancho/2 > a.getX()-a.getAncho()/2 &&  
               this.y-this.alto/2<a.getY()+a.getAlto()/2 &&    
               this.y+this.alto/2>a.getY()-a.getAlto()/2) {    
                return true;
            } else {
                return false;
            }

        } else if(a.getTipo() == 3) {  

        	
            if(this.x-this.ancho/2 < a.getX()+a.getAncho()/2 &&  
               this.x+this.ancho/2 > a.getX()-a.getAncho()/2 &&   
               this.y-this.alto/2<a.getY()+a.getAlto()/2 &&      
               this.y+this.alto/2>a.getY()-a.getAlto()/2) {      
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
    
    //---- sakura en relacion con ninjas y rasengan (habilidad espacial) ----
    public Rasengan sakuraDisparar() {
		return new Rasengan(this.x,this.y,direccion,imagen4); 
	}   					
    public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getAngulo() {
		return angulo;		
	}

	public double getAncho() {
		return this.ancho;
	}
	
	public double getAlto() {
		return this.alto;
	}
	
	public double getMovimiento() {
		return this.movimiento;
	}

}
	
	

	
	      

		
	
	
	
	
	
	
	


