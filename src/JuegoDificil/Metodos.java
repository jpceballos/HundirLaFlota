/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDificil;

import Interface.Ganar;
import Interface.Perder;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Juan Padilla Ceballos
 */

public class Metodos {
    
    private static Ventana juego = new Ventana();
	
    public static Tablero t_jugador = juego.juego.t_jugador;
		
    private static Tablero t_contrincante = juego.juego.t_contrincante;
	
    private static Texto texto = juego.texto;
		
    private static int[] barco_colocado = new int[5];
		
    private static int bucle = 1;
		
    private static JLabel titulo;
    
    // Creacion de metodos
    
    // Creacion de metodo constructor 
    
    public Metodos() throws InterruptedException{
        iniciar();
    }
     
    // Creacion del metodo con el cual iniciamos el juego
    
    public static void iniciar() throws InterruptedException{
        
        t_jugador.setBorder(new EmptyBorder(0,5,0,25));
	t_contrincante.rotar.setVisible(false);
		
	// El Jugador coloca sus 5 barcos
		
	colocarBarco(t_jugador, 3,"Coloca el barco de 3 casillas.");
		
	colocarBarco(t_jugador, 3,"Coloca otro barco de 3 casillas.");
		
	colocarBarco(t_jugador, 4,"Coloca el barco de 4 casillas.");
		
	colocarBarco(t_jugador, 4,"Coloca otro barco de 4 casillas");
		
	colocarBarco(t_jugador, 5,"Coloca el barco de 5 casillas");
		
	// La computadora coloca sus 5 barcos aleatoriamente
		
	colocarBarcoAleatorio(t_contrincante,3,1);
		
	colocarBarcoAleatorio(t_contrincante,3,2);
			
	colocarBarcoAleatorio(t_contrincante,4,3);
		
	colocarBarcoAleatorio(t_contrincante,4,4);
		
	colocarBarcoAleatorio(t_contrincante,5,5);
		
	texto.setTamanoFuente(16.5f);
	texto.setTexto("La computadora ha colocado su barcos, puedes empezar a jugar");
		
	// El juego comienza y el jugador puede elegir casillas
		
	while(bucle==1){
            turno();
	}
    }
    
    // Metodo con el cual el jugador coloca los barcos
    
    public static void colocarBarco(Tablero tablero, int n_barcos, String ttexto) throws InterruptedException{
        
        texto.setTexto(ttexto);

	tablero.anadirBarco(n_barcos);
				
	while(tablero.proceso==1){
            Thread.sleep(1);
	}
    }
	
    // Metodo para que la computadora coloque los barcos
    
    public static void colocarBarcoAleatorio(Tablero tablero, int n_barcos, int barco_contador){
		
	int aleatorio = (int) (Math.random()*2+1);
		
	if(aleatorio==1){
            colocarBarcoAleatorioHorizontal(tablero,n_barcos,barco_contador);
	}else{
            colocarBarcoAleatorioVertical(tablero,n_barcos,barco_contador);
            }	
    }
	
    // Metodo para que la computadora coloque los barcos en horizontal
    
    public static void colocarBarcoAleatorioHorizontal(Tablero tablero, int n_barcos, int barco_contador){
	int aleatorio = (int) (Math.random()*399+1);
	boolean valido = true;
	int bucle = 1;
		
	while(bucle == 1){
            valido = true;
            aleatorio = (int) (Math.random()*399+1);
            
            for(int i = 0; i<5;i++){
		if(barco_colocado[i]==aleatorio){
                    valido=false;
		}
            }
				
            if(aleatorio%20>20-n_barcos){
		valido = false;
            }
				
            if(tablero.boton[aleatorio].getActivo()){
		valido = false;
            }
				
            if(tablero.anadirBarcoHorizontal(tablero.boton[aleatorio], n_barcos, barco_contador)==true && valido){
			
		for(int x = 0; x<400;x++){
						
                    if(tablero.boton[x].getIluminado()){
			tablero.boton[x].setActivo(true);
			tablero.boton[x].setColorDefault();
			tablero.boton[x].setIdBarco(barco_contador);
			tablero.boton[x].setIluminado(false);
                    }
		}
					
		barco_colocado[barco_contador-1] = aleatorio;
		bucle = 0;
            }else{}
        }
	tablero.barcosHorizontalBorrar(null);
    }
    
    // Metodo para que la computadora coloque los barcos en vertical 
    
    public static void colocarBarcoAleatorioVertical(Tablero tablero, int n_barcos, int barco_contador){
	
        int aleatorio = (int) (Math.random()*399+1);
	boolean valido = true;
	int bucle = 1;
		
	while(bucle == 1){
            
            aleatorio = (int) (Math.random()*399+1);
            
            for(int i = 0; i<5;i++){
		
                if(barco_colocado[i]==aleatorio){
                    valido=false;
		}
            }
				
            if(aleatorio/20<n_barcos-1){
		valido = false;
            }
				
            if(tablero.boton[aleatorio].getActivo()){
		valido = false;
            }
				
            if(tablero.anadirBarcoVertical(tablero.boton[aleatorio], n_barcos, barco_contador)==true && valido){
					
		boolean valido2 = tablero.anadirBarcoVertical(tablero.boton[aleatorio], n_barcos, barco_contador);
					
		for(int x = 0; x<400;x++){
						
                    int contador_interno = 0;
						
                    if(contador_interno<n_barcos)
						
                    if(tablero.boton[x].getIluminado()){
		        tablero.boton[x].setActivo(true);
			tablero.boton[x].setColorDefault();
			tablero.boton[x].setIdBarco(barco_contador);
                        tablero.boton[x].setIluminado(false);
			contador_interno++;
                    }
		}
					
		barco_colocado[barco_contador-1] = aleatorio;
		bucle = 0;
		valido = false;
            }else{
		valido = true;
		}
	}
	tablero.barcosHorizontalBorrar(null);
    }

    // Metodo mediante el cual controlamos cuando el jugador gana o pierde
    
    public static void turno() throws InterruptedException{
		
        int contador1 = 0;
	int contador2 = 0;
	t_contrincante.elegirCasilla(-1);
		
	while(t_contrincante.proceso==1){
            Thread.sleep(1);
	}
		
	for(int x = 0; x<400;x++){
	
            if(t_contrincante.boton[x].getActivo()){
		contador1++;
            }
            
            if(t_contrincante.boton[x].getTocado()){
		contador2++;
            }
	}
		
	System.out.println("contador1:"+contador1);
	System.out.println("contador2:"+contador2);
		
	if(contador1==contador2){
            
            bucle = 0;
            juego.dispose();
            Ganar ganar = new Ganar();
        }
		
	if(contador1!=contador2){
            
            contador1 = 0;
            contador2 = 0;
            texto.setTexto("La Computadora esta eligiendo una casilla para atacar.");
            Thread.sleep((int)(Math.random()*2000+500));
            int aleatorio = (int) (Math.random()*400);
            t_jugador.elegirCasilla(aleatorio);
			
            for(int x = 0; x<400;x++){
				
                if(t_jugador.boton[x].getActivo()){
                    contador1++;
		}
				
                if(t_jugador.boton[x].getHundido()){
                    contador2++;
		}
            }
			
            if(contador1==contador2){
                
		bucle = 0;
		juego.dispose();
                Perder perder = new Perder();
       
            }else{
                texto.setTexto("La Computadora acaba de atacar, ahora es tu turno");
		}
	}
    }
}
