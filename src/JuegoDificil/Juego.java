package JuegoDificil;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Juego extends JPanel{
	
    Tablero t_contrincante;
    Tablero t_jugador;

    // Creacion del metodo constructor
    
    Juego(){

        GridLayout layout = new GridLayout(1,2);
	setLayout(layout);
		
	// Creacion del tablero del contrincante (computadora)	
	
        t_contrincante = new Tablero(false);
	add(t_contrincante);
				
	// Creacion del tablero del jugador
				
        t_jugador = new Tablero(true);
	add(t_jugador);
    }
}
