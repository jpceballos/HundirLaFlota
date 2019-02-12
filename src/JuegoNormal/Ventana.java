package JuegoNormal;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	Juego juego;
	Texto texto;
	Titulo titulo;
	
    // Creacion del metodo constructor
        
    Ventana(){
        
        setTitle("Hundir la Flota");
		
    // Caracteristicas de la ventana
		
	this.setResizable(false);
		
	setBounds(100,100,550,1040);
		
        setLocationRelativeTo(null);
			
	BorderLayout layout = new BorderLayout();
	setLayout(layout);
		
	juego = new Juego();
	add(juego, BorderLayout.CENTER);
		
	texto = new Texto();
	add(texto, BorderLayout.SOUTH);
		
	titulo = new Titulo();
	add(titulo, BorderLayout.NORTH);
		
	setVisible(true);
    }
}
