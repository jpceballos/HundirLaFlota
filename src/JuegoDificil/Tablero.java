package JuegoDificil;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tablero extends JPanel{

    // Atributos
    
    Boton[] boton = new Boton [400];
    JLabel[] letra = new JLabel[21];
    JLabel[] numero = new JLabel[20];
    
    JButton rotar;
    JLabel titulo_visible;
	
    int rotacion = 0;
    int proceso = 0; // 0 = colocacion de barcos no iniciada // 1 = colocando barcos // 2 = proceso terminado
    boolean es_posible_colocar = true; //indicar si es posible o no colocar el barco
    int contador_barco = 1;
    int barcos_hundidos = 0;
	
    EanadirBarco e1 = new EanadirBarco();
    EcambiarRotacion e2 = new EcambiarRotacion();
    EelegirCasilla e3 = new EelegirCasilla();

    // Creacion del metodo constructor
    
    Tablero(boolean jugador){
		
        // Caracteristicas del tablero de juego
        
	GridLayout layout = new GridLayout(22,21);
	setLayout(layout);
	setBorder(new EmptyBorder(15,5,0,25));
		
	// Creacion del tablero de juego
	
        crearTablero();
    }
	
    // Metodos para crear las letra, numeros y el boton de rotar
	
    public void crearTablero(){
	
        // Creacion de las letras
		
	for(int x = 0;x<21;x++){
			
            switch(x){
				
                case 0: letra[x] = new JLabel("", SwingConstants.CENTER);break;
		case 1: letra[x] = new JLabel("A", SwingConstants.CENTER);break;
		case 2: letra[x] = new JLabel("B", SwingConstants.CENTER);break;
		case 3: letra[x] = new JLabel("C", SwingConstants.CENTER);break;
		case 4: letra[x] = new JLabel("D", SwingConstants.CENTER);break;
		case 5: letra[x] = new JLabel("E", SwingConstants.CENTER);break;
		case 6: letra[x] = new JLabel("F", SwingConstants.CENTER);break;
		case 7: letra[x] = new JLabel("G", SwingConstants.CENTER);break;
		case 8: letra[x] = new JLabel("H", SwingConstants.CENTER);break;
		case 9: letra[x] = new JLabel("I", SwingConstants.CENTER);break;
		case 10: letra[x] = new JLabel("J", SwingConstants.CENTER);break;
                case 11: letra[x] = new JLabel("K", SwingConstants.CENTER);break;
                case 12: letra[x] = new JLabel("L", SwingConstants.CENTER);break;
                case 13: letra[x] = new JLabel("M", SwingConstants.CENTER);break;
                case 14: letra[x] = new JLabel("N", SwingConstants.CENTER);break;
                case 15: letra[x] = new JLabel("O", SwingConstants.CENTER);break;
                case 16: letra[x] = new JLabel("P", SwingConstants.CENTER);break;
                case 17: letra[x] = new JLabel("Q", SwingConstants.CENTER);break;
                case 18: letra[x] = new JLabel("R", SwingConstants.CENTER);break;
                case 19: letra[x] = new JLabel("S", SwingConstants.CENTER);break;
                case 20: letra[x] = new JLabel("T", SwingConstants.CENTER);break;
            }
            add(letra[x]);
	}
		
	// Creacion de los numeros
	
        int contador = 0;
		
            for(int x = 0;x<400;x++){
			
		if(x%20==0 && x!=399){
				
                    numero[contador] = new JLabel(""+(contador+1), SwingConstants.CENTER);
                    add(numero[contador]);
                    contador++;
		}
			
                boton[x] = new Boton("");
		boton[x].setSize(25, 25);
		add(boton[x]);
            }
		
            // Creacion del boton para rotar los barcos
            
            JPanel panelrotar = new JPanel();
            this.add(panelrotar);
            panelrotar.setLayout(new FlowLayout());
            rotar = new JButton("Rotar");
            rotar.addActionListener(new EcambiarRotacion());
            rotar.setBackground(Color.cyan);
            panelrotar.add(rotar);
    }

    // Creacion de metodos para interactuar con el tablero (añadir barcos, elegir casillas)
    
    public void anadirBarco(int n_barcos){
	
        proceso = 1;
		
	for(int x = 0; x<400; x++){
            e1.setN_barcos(n_barcos);
            boton[x].addMouseListener(e1);
            boton[x].addKeyListener(e2);
	}
    }
	
    public void terminarAnadirBarco(){
	
        for(int x = 0; x<400; x++){
            EanadirBarco e = new EanadirBarco();
            boton[x].removeMouseListener(e1);
            boton[x].removeKeyListener(e2);
	}
	proceso = 2;
    }
	
    public boolean anadirBarcoHorizontal(Boton objeto, int n_barcos, int barco_contador){
	
        int bandera = 0;
		
	for(int x=0;x<400;x++){
            int linea = x/20;
            linea = linea * 20;
            int numero = x - linea;
            int contador = 0;
			
            if(objeto==boton[x] && !boton[x].getActivo()){
		
                if(numero<=20-n_barcos){
                    
                    for(int y=0;y<=20-n_barcos;y++){
			
                        if(objeto==boton[x] && numero==y){
						
                            for(int w = 0;w<n_barcos;w++){
							
                                if(contador==0){
                                    
                                    if(!boton[x+contador].getActivo()){
					boton[x+contador].setColorEleccionVerde();
					boton[x+contador].setIluminado(true);
					boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.black));	
                                    }else{
					bandera++;
                                        }
				}else if(contador==n_barcos-1){
					
                                        if(!boton[x+contador].getActivo()){
                                            boton[x+contador].setColorEleccionVerde();
                                            boton[x+contador].setIluminado(true);
                                            boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));	
					}else{
                                            bandera++;
                                            }
					}else{
                                            if(!boton[x+contador].getActivo()){
						boton[x+contador].setColorEleccionVerde();
                                                boton[x+contador].setIluminado(true);
						boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));	
                                            }else{
						bandera++;
						}
                                            }
                                            contador++;
                            }
			}
                    }
		}
            }		
        }
	
        if(bandera==0){
            es_posible_colocar = true;
	}else{
            es_posible_colocar = false;
            }
		
	if(es_posible_colocar){
            return true;
	}else{
            for(int x = 0; x<400;x++){
				
		if(boton[x].getIluminado()){
					
                    boton[x].setIluminado(false);
		}
            }
            return false;
            }
    }
	
    public boolean anadirBarcoVertical(Boton objeto, int n_barcos, int barco_contador){
	
        int bandera = 0;
		
	for(int x=0;x<400;x++){
			
            int linea = x/20;
            int contador = 0;
			
            if(linea>=n_barcos-1){
				
                for(int y=n_barcos-1;y<20;y++){
					
                    if(objeto==boton[x] && linea==y){
						
                        for(int w = 0;w<n_barcos;w++){
							
                            if(contador==0){
								
                                if(!boton[x-contador].getActivo()){
                                    boton[x-contador].setColorEleccionVerde();
                                    boton[x-contador].setIluminado(true);
                                    boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.black));	
				}else{
                                    bandera++;
                                    }
                            }else if(contador/20==n_barcos-1){
                                    if(!boton[x-contador].getActivo()){
					boton[x-contador].setColorEleccionVerde();
					boton[x-contador].setIluminado(true);
					boton[x-contador].setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black));	
                                    }else{
					bandera++;
					}
                                    }else{
					if(!boton[x-contador].getActivo()){
                                            boton[x-contador].setColorEleccionVerde();
                                            boton[x-contador].setIluminado(true);
                                            boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));
					}else{
                                            bandera++;
                                            }
					}
					contador+=20;
			}
                    }
		}
            }
	}
		
	if(bandera==0){
            es_posible_colocar = true;
	}else{
            es_posible_colocar = false;
            }
		
	if(es_posible_colocar){
            return true;
	}else{
            for(int x = 0; x<400;x++){
				
		if(boton[x].getIluminado()){
                    boton[x].setIluminado(false);
		}
            }
            return false;
            }
    }
	
    public void barcosHorizontalBorrar(Boton objeto){
		
        for(int x=0;x<400;x++){			
			
            if(!boton[x].getActivo()){
		boton[x].setBackground(new JButton().getBackground());
		boton[x].setBorder(new JButton().getBorder());
            }
	}
    }
	
    
    public void elegirCasilla(int casilla){
		
        proceso = 1;
		
	if(casilla > -1){
            //comprobar si hay barco en esa casilla
            if(boton[casilla].getActivo()){
                boton[casilla].setColorTocado();
		boton[casilla].setTocado(true);
            }
			
            //comprobar si no hay barco en esa casilla
            else if(!boton[casilla].getActivo()){
                    boton[casilla].setColorAgua();
		}
		terminarElegirCasilla();
	}else{
            for(int x = 0; x<400; x++){
                boton[x].addMouseListener(e3);
            }
            }
    }
	
    public void terminarElegirCasilla(){
	
        int hundir []=  new int [5];
	hundir[0]=0;
	hundir[1]=0;
	hundir[2]=0;
	hundir[3]=0;
	hundir[4]=0;
		
	for(int x = 0; x<400; x++){
            boton[x].removeMouseListener(e3);
            for(int i = 0; i<5; i++){
                if(boton[x].getIdBarco()==i+1){
                    if(boton[x].getTocado()){
                    }else{
			hundir[i]++;
			}
		}
            }
	}
		
	for(int i = 0; i<5;i++){
			
            if(hundir[i]==0){
				
                for(int x = 0; x<400; x++){
					
                    if(boton[x].getIdBarco()==i+1){
			boton[x].setColorHundido();
			boton[x].setHundido(true);
			barcos_hundidos++;
			boton[x].setText(""+boton[x].getIdBarco());
                    }
		}
            }
	}
	proceso = 2;
    }
		
    // Creacion de clases propias para poner los barcos, elegir rotacion y seleccionar casillas con el mouse
	
    class EanadirBarco implements MouseListener{
	
        int n_barcos = 0;

	// Creacion de metodos	
		
        public void barcosHorizontal(Boton objeto){
            
            int bandera = 0;
			
            for(int x=0;x<400;x++){
		int linea = x/20;
		linea = linea * 20;
		int numero = x - linea;
		int contador = 0;
				
		if(objeto==boton[x] && !boton[x].getActivo()){
				
                    if(numero<=20-n_barcos){
			
                        for(int y=0;y<=20-n_barcos;y++){
						
                            if(objeto==boton[x] && numero==y){
							
                                for(int w = 0;w<n_barcos;w++){
								
                                    if(contador==0){
									
                                        if(!boton[x+contador].getActivo()){
                                            boton[x+contador].setColorEleccionVerde();
                                            boton[x+contador].setIluminado(true);
                                            boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.black));	
					}else{
                                            bandera++;
                                            }
                                    }else if(contador==n_barcos-1){
                                            if(!boton[x+contador].getActivo()){
						boton[x+contador].setColorEleccionVerde();
						boton[x+contador].setIluminado(true);
						boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));	
                                            }else{
						bandera++;
						}
                                            }else{
						if(!boton[x+contador].getActivo()){
                                                    boton[x+contador].setColorEleccionVerde();
                                                    boton[x+contador].setIluminado(true);
                                                    boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));	
						}else{
                                                    bandera++;
                                                    }
                                                }
						
                                    if(bandera==0){
					es_posible_colocar = true;
                                    }else{
					es_posible_colocar = false;
					}
					contador++;
				}
                            }
			}
                    }else if(numero>20-n_barcos){
                                es_posible_colocar = false;
                            
                                for(int y=21-n_barcos;y<20;y++){
						
                                    if(objeto==boton[x] && numero==y){
							
					for(int w = 0;w<20-y;w++){
								
                                            if(contador==0){
						
                                                if(!boton[x+contador].getActivo()){
                                                    boton[x+contador].setColorEleccionRojo();
                                                    boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.black));	
						}
                                            }else if(contador==n_barcos-2){
									
                                                    if(!boton[x+contador].getActivo()){
							boton[x+contador].setColorEleccionRojo();
							boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.black));		
                                                    }
						}else{
                                                    if(!boton[x+contador].getActivo()){
                                                        boton[x+contador].setColorEleccionRojo();
                                                        boton[x+contador].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));	
                                                       }
                                                    }
					contador++;
					}
                                    }
				}
                            }
		}
					
            }
	}
	
	public void barcosVertical(Boton objeto){
			
            int bandera = 0;
			
            for(int x=0;x<400;x++){
		int linea = x/20;
                int contador = 0;
                
                if(linea>=n_barcos-1){
                    for(int y=n_barcos-1;y<20;y++){
			if(objeto==boton[x] && linea==y){
                            for(int w = 0;w<n_barcos;w++){
				if(contador==0){
                                    if(!boton[x-contador].getActivo()){
					boton[x-contador].setColorEleccionVerde();
					boton[x-contador].setIluminado(true);
					boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.black));	
                                    }else{
                                        bandera++;
                                        }
				}else if(contador/20==n_barcos-1){
                                        if(!boton[x-contador].getActivo()){
                                            boton[x-contador].setColorEleccionVerde();
                                            boton[x-contador].setIluminado(true);
                                            boton[x-contador].setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black));	
					}else{
                                            bandera++;
                                            }
					}else{
                                            if(!boton[x-contador].getActivo()){
						boton[x-contador].setColorEleccionVerde();
						boton[x-contador].setIluminado(true);
						boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));
                                            }else{
						bandera++;
						}
                                            }
				if(bandera==0){
                                    es_posible_colocar = true;
				}else{
                                    es_posible_colocar = false;
                                    }
                                contador+=20;
                            }
                        }
                    }
		}else if(linea<n_barcos){
                        es_posible_colocar = false;
                            for(int y=n_barcos;y>=0;y--){
                                if(objeto==boton[x] && linea==y){
                                    for(int w = y;w>=0;w--){
					if(contador==0){
                                            if(!boton[x-contador].getActivo()){
						boton[x-contador].setColorEleccionRojo();
						boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.black));
                                            }
					}else if(linea==1){
						if(!boton[x-contador].getActivo()){
                                                    boton[x-contador].setColorEleccionRojo();
                                                    boton[x-contador].setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black));	
						}
                                                }else{
                                                    if(!boton[x-contador].getActivo()){
							boton[x-contador].setColorEleccionRojo();
							boton[x-contador].setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.black));	
                                                    }
                                                    }
								
						contador+=20;
                                    }
				}
                            }
			}
            }
        }
		
	public void barcosHorizontalBorrar(Boton objeto){
            for(int x=0;x<400;x++){
		if(!boton[x].getActivo()){
                    boton[x].setBackground(new JButton().getBackground());
                    boton[x].setBorder(new JButton().getBorder());
		}
            }
	}
		
	public void barcosVerticalBorrar(Boton objeto){
            for(int x=0;x<400;x++){
		if(!boton[x].getActivo()){
                    boton[x].setBackground(new JButton().getBackground());
                    boton[x].setBorder(new JButton().getBorder());
		}
            }
	}

		
		
		

	@Override
	public void mouseClicked(MouseEvent arg0){
            if(es_posible_colocar){
		for(int x = 0; x<400;x++){
                    if(boton[x].getIluminado()){
			boton[x].setActivo(true);
			boton[x].setColorActivo();
			boton[x].setIdBarco(contador_barco);
                    }
		}
                contador_barco++;
                terminarAnadirBarco();
            }
        }
		
        @Override
	public void mouseEntered(MouseEvent e) {
            Boton objeto = (Boton) e.getSource();
            if(rotacion == 0){
                barcosHorizontal(objeto);
            }else if(rotacion == 1){
		barcosVertical(objeto);
		}
	}

	@Override 
	public void mouseExited(MouseEvent e) {
            Boton objeto = (Boton) e.getSource();
            if(rotacion == 0){
		barcosHorizontalBorrar(objeto);
            }else if(rotacion == 1){
		barcosVerticalBorrar(objeto);
		}
            for(int x = 0; x<400;x++){
                boton[x].iluminado=false;
            }
	}

	@Override
	public void mousePressed(MouseEvent e) {
        }

	@Override
	public void mouseReleased(MouseEvent e) {
	}
		
	public void setN_barcos(int barcos){
            n_barcos = barcos;
	}
		
    }
	
    class EcambiarRotacion extends EanadirBarco implements KeyListener, ActionListener{

	@Override
	public void keyPressed(KeyEvent e) {
        }

	@Override
	public void keyReleased(KeyEvent e) {
            for(int x = 0; x<400; x++){
		this.barcosHorizontalBorrar((Boton)e.getSource());
            }
            
            if(rotacion == 0){
		rotacion = 1;
                barcosVertical((Boton)e.getSource());
            }else if (rotacion == 1){
                        rotacion = 0;
			barcosHorizontal((Boton)e.getSource());
                    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
            for(int x = 0; x<400; x++){
            }
            
            if(rotacion == 0){
		rotacion = 1;
            }else if (rotacion == 1){
                        rotacion = 0;
                    }
	}
    }
	
    class EelegirCasilla implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

        @Override
	public void mouseEntered(MouseEvent e) {
            Boton boton = (Boton) e.getSource();
            if(!(boton.getAgua() || boton.getTocado())){
		boton.setColorSeleccion();
            }
	}

        @Override
        public void mouseExited(MouseEvent e) {
            Boton boton = (Boton) e.getSource();
            if(!(boton.getAgua() || boton.getTocado())){
		boton.setColorDefault();
            }
	}

	@Override
	public void mousePressed(MouseEvent e) {
            Boton boton = (Boton) e.getSource();
            if(boton.getActivo()){ //comprobar si hay barco en esa casilla
		boton.setColorTocado();
		boton.setTocado(true);
            }else if(!boton.getActivo()){ //comprobar si no hay barco en esa casilla
			boton.setColorAgua();
			boton.setAgua(true);
                    }
            terminarElegirCasilla();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
    }
}
	
