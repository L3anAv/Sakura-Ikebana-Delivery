package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Sakura {
	private double x;
	private Image sakura;
	private double y;
	private double angulo;
	private double ancho;
	private double alto;
	private double movimiento;
	private int direccion; 
	private String imagen4 = "rasengan.png";
	
//	 imagen = 40x40	
	public Sakura(double x, double y, double angulo,double movimiento) {
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		sakura = Herramientas.cargarImagen("sakura-chibi.png");
		this.alto=10;
		this.ancho=15;
		this.movimiento=movimiento;
	}
	
	// ---- dibujar sakura ----
	
	public void dibujar (Entorno e) {
//		e.dibujarRectangulo(x, y, ancho, alto, 0, color);
		e.dibujarImagen(sakura, x, y, angulo);
	}
	
	// ---- movimiento de sakura y limites ----

	public void moverDerecha(Entorno x,Manzana[] manzanas) {
		if (!(this.x+10+this.ancho/2>x.ancho())) {
			  this.x+=this.movimiento;			  
		} if (movimientoRangoManzanas(manzanas)) {
			this.x-=this.movimiento;	
		}
		direccion=1; // 1=derecha 
		}
	
	public void moverIzquierda(Manzana[] manzanas) {                              

		if (!(this.x+1-this.ancho<=0)) {
			this.x-=this.movimiento;
		}if (movimientoRangoManzanas(manzanas)) {
			this.x+=this.movimiento;
		}
		direccion=2; // 2 =izquierda
		}
	public void moverArriba(Manzana[] manzanas) {
		if (!(this.y-50-this.alto<0) ) {
			this.y-=this.movimiento;
		}if (movimientoRangoManzanas(manzanas)) {
			this.y+=this.movimiento;
		}
		direccion=3;   // 3=Arriba
	}
	public void moverAbajo(Entorno x, Manzana[] manzanas) {
		if (!(this.y+12+this.alto>x.alto())) {
			  this.y+=this.movimiento;		
		}if (movimientoRangoManzanas(manzanas)) {
			this.y-=this.movimiento;
		}
		direccion=4; // 4= abajo
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
	public boolean movimientoRangoManzanas(Manzana[] manzanas) {
		int cont=0;
		//x 85 y 55
		for (int i=0 ; i<manzanas.length;i++) {
			if (colision(this.x+90,this.y+70,this.ancho,this.alto,manzanas[i].getX(),manzanas[i].getY(),manzanas[i].getAlto()+28,manzanas[i].getAncho()+15)==true) { //modificar x e del sakura o manzanas[i] y si hay problemas de rango...
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
	
	// ---- metodo colison entre dos rectangulos ----
	
    public static boolean colision(double x1, double y1, double anchoX, double altoX,double x2, double y2,double altoY, double anchoY) {    //------ pensado para dos cuadrados-------
		 if (x1<x2+anchoY  &&  x1+anchoX>x2 && y1 < y2+altoY && y1+altoX >y2) {
			 return true;
		 }else {
		return false;
		 }
	}	

	//---- sakura en relacion con ninjas y rasengan (habilidad espacial) ----
	
    public Rasengan disparar() {
		return new Rasengan(this.x,this.y,direccion,imagen4);
	}
	public void habilidadEspecialRasengan(Entorno entorno,Manzana[] manzanas, Rasengan[] rasengan,Ninja[] ninjas) {
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {

			boolean dispararRasengan = false;
			for (int i = 0; i < rasengan.length && !dispararRasengan; i++) {
				if (rasengan[i] == null) 
				{
					rasengan[i] = disparar();
					dispararRasengan = true;
				}
			}
		}
		//dibuja el kamehameha y desaparece segun los limites en X e Y
		for (int i = 0; i < rasengan.length; i++) {
			if (rasengan[i] != null) {
				rasengan[i].mover();
				rasengan[i].Dibujar(entorno);
				
				if(rasengan[i].getX() <= 0 || rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i]) ) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getX()  >= entorno.ancho()|| rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getY() <= 0 || rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
				{
					rasengan[i] = null;
				}
				else if(rasengan[i].getY()  >= entorno.alto()|| rasengan[i].movimientoRangoManzasRasengan(manzanas, rasengan[i])) 
				{
					rasengan[i] = null;
				}
			}
		}
		for (int i = 0; i < ninjas.length; i++) {
            if(ninjas[i]!=null && rasengan[0]!=null) {
                    if(ninjas[i].colisionRasengan(rasengan[0],ninjas[i])==true) {

                        rasengan[0]=null;
                        ninjas[i]=null;
                    }
                }
            }
	
     }
	
	// ---- getters ----						
	
    public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
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
	
	

	
	      

		
	
	
	
	
	
	
	


