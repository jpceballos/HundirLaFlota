/**
 *
 * @author Juan Padilla Ceballos
 */

package JuegoDificil;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Titulo extends JPanel{
    JPanel barra;
    JPanel panel_titulo = new JPanel();
    JLabel titulo;
    JLabel titulo_visible;
	
    // Creacion de metodo constructor
    
    Titulo(){
	
        barra = new JPanel();
	setLayout(new GridLayout(2,1));
	panel_titulo.setBorder(new EmptyBorder(0,0,0,0));
	add(barra);
		
	add(panel_titulo);
	this.setBorder(new EmptyBorder(0,0,0,0));
	
	titulo = new JLabel("HUNDIR LA FLOTA",SwingConstants.CENTER);
	titulo.setFont(new Font("Brush Script MT",1,30));
	titulo.setForeground(new Color(51, 133, 255));
	titulo.setVisible(true);
	
	crearMenu();
	panel_titulo.add(titulo);
		
    }

    // Metodos para crear menu y cambiar los barcos de color
    
    public void crearMenu(){
	
        JMenuBar menu = new JMenuBar();
	JMenu color_barcos = new JMenu("Color Barcos");
	color_barcos.setMnemonic(KeyEvent.VK_C);
        
        JMenuItem color_rosa = new JMenuItem("Rosa");
	color_rosa.setMnemonic(KeyEvent.VK_R);
	color_rosa.addActionListener(new eColorRosa());
		
	JMenuItem color_verde = new JMenuItem("Verde");
	color_verde.setMnemonic(KeyEvent.VK_V);
	color_verde.addActionListener(new eColorVerde());
		
	JMenuItem color_morado= new JMenuItem("Morado");
	color_morado.setMnemonic(KeyEvent.VK_M);
	color_morado.addActionListener(new eColorMorado());
		
	JMenuItem color_naranja= new JMenuItem("Naranja");
	color_naranja.setMnemonic(KeyEvent.VK_N);
	color_naranja.addActionListener(new eColorNaranja());
	
	color_barcos.add(color_rosa);
	color_barcos.add(color_verde);
	color_barcos.add(color_morado);
	color_barcos.add(color_naranja);
		
	menu.add(color_barcos);
	barra.add(menu);
    } 
	
    // Creacion de clases para los diferentes colores de los barcos
    
    class eColorRosa implements ActionListener{
	Color color = Color.PINK;

	@Override
	public void actionPerformed(ActionEvent e) {
            for(int x = 0; x<400;x++){
		if(Metodos.t_jugador.boton[x].getActivo() && !Metodos.t_jugador.boton[x].getTocado() && !Metodos.t_jugador.boton[x].getHundido()){
                    Metodos.t_jugador.boton[x].setBackground(color);
                }
            }
            Boton.color = color;
	}
    }
	
    class eColorVerde implements ActionListener{
	Color color = Color.green;

	@Override
	public void actionPerformed(ActionEvent e) {
            for(int x = 0; x<400;x++){
		if(Metodos.t_jugador.boton[x].getActivo() && !Metodos.t_jugador.boton[x].getTocado() && !Metodos.t_jugador.boton[x].getHundido()){
                    Metodos.t_jugador.boton[x].setBackground(color);
		}
            }
            Boton.color = color;
	}
    }

    class eColorMorado implements ActionListener{
	Color color = new Color(255, 51, 153);

	@Override
	public void actionPerformed(ActionEvent e) {
            for(int x = 0; x<400;x++){
		if(Metodos.t_jugador.boton[x].getActivo() && !Metodos.t_jugador.boton[x].getTocado() && !Metodos.t_jugador.boton[x].getHundido()){
                    Metodos.t_jugador.boton[x].setBackground(color);
		}
            }
            Boton.color = color;
	}
    }
	
    class eColorNaranja implements ActionListener{
	Color color = new Color(255, 102, 0);

	@Override
	public void actionPerformed(ActionEvent e) {
            for(int x = 0; x<400;x++){
		if(Metodos.t_jugador.boton[x].getActivo() && !Metodos.t_jugador.boton[x].getTocado() && !Metodos.t_jugador.boton[x].getHundido()){
                    Metodos.t_jugador.boton[x].setBackground(color);
		}
            }
            Boton.color = color;
	}
    }
}
