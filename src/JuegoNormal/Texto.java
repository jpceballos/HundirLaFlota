/**
 *
 * @author Juan Padilla Ceballos
 */

package JuegoNormal;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Texto extends JPanel{
	
    JLabel texto = new JLabel();

    // Creacion metodo constructor
    
    Texto(){
	this.setBorder(BorderFactory.createMatteBorder(0, 0, 25, 0, new JPanel().getBackground()));
	add(texto);
	texto.setFont(this.getFont().deriveFont(17.0f));
    }
	
    // Metodos
	
    public void setTexto(String texto){
	this.texto.setText(texto);
    }
	
    public void setTamanoFuente(float numero){
	this.texto.setFont(this.texto.getFont().deriveFont(numero));
    }
}
