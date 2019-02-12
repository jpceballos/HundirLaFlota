/**
 *
 * @author Juan Padilla Ceballos
 */

package JuegoFacil;

import java.awt.Color;
import javax.swing.ImageIcon;

import javax.swing.JButton;

public class Boton extends JButton{

    // Atributos
    
    boolean activo = false;
    boolean iluminado = false;
    boolean tocado = false;
    boolean agua = false;
    boolean hundido = false;
    int id_barco = 0;
    public static Color color = Color.green;
	
    // Metodo constructor
    
    Boton(String texto){
	this.setText(texto);
    }
	
    // Creacion de Setters
	
    public void setActivo(boolean activo){
	this.activo = activo;
    }
	
    public void setIluminado(boolean activo){
	iluminado = activo;
    }
	
    public void setIdBarco(int barco){
	id_barco = barco;
    }
	
    public void setTocado(boolean bool){
	tocado = bool;
    }
	
    public void setAgua(boolean bool){
	agua = bool;
    }
	
    public void setHundido(boolean bool){
	hundido = bool;
    }
	
    // Creacion de Getters
	
    public boolean getActivo(){
	return activo;
    }
	
    public boolean getIluminado(){
	return iluminado;
    }
	
    public int getIdBarco(){
	return id_barco;
    }
	
    public boolean getTocado(){
	return tocado;
    }
	
    public boolean getAgua(){
	return agua;
    }
	
    public boolean getHundido(){
	return agua;
    }
	
    // Creacion de metodos que dan color a los barcos que pone el jugador en su panel
	
    public void setColorEleccionVerde(){
	this.setBackground(new Color(153, 255, 153));
    }
	
    public void setColorEleccionRojo(){
	this.setBackground(new Color(255, 153, 153));
    }
	
    public void setColorActivo(){
	this.setBackground(color);
    }
	
    public void setColorDefault(){
	this.setBackground(new JButton().getBackground());
	this.setBorder(new JButton().getBorder());
    }
	
    public void setColorSeleccion(){
	this.setBackground(new Color(255, 179, 102));
    }
	
    // Creacion de metodos para poner imagenes en las casillas para que aparezca agua, tocado y hundido
    
    public void setColorTocado(){
	this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/explosion.jpg")));
    }
	
    public void setColorAgua(){
	this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/mar.jpg")));	
    }
	
    public void setColorHundido(){
	this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/hundido.jpg")));	
    }
}
