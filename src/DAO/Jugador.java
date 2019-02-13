/**
 *
 * @author Juan Padilla Ceballos
 */

package DAO;

public class Jugador {
    
    // Atributos
    
    private  String nombre;
    private  int puntosfacil;
    private  int puntosnormal;
    private  int puntosdificil;
    
    // Creacion del metodo constructor
    
    public Jugador (String nombre, int puntosfacil,int puntosnormal, int puntosdificil){
        this.nombre = nombre;
        this.puntosfacil = puntosfacil;
        this.puntosnormal = puntosnormal;
        this.puntosdificil = puntosdificil;    
    }
    
    // Getters
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPuntosfacil(){
        return puntosfacil;
    }
    
    public int getPuntosnormal(){
        return puntosnormal;
    }
    
    public int getPuntosdificil(){
        return puntosdificil;
    }
    
    // Setters 
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPuntosfacil(int puntosfacil){
        this.puntosfacil = puntosfacil;
    }
    
    public void setPuntosnormal(int puntosnormal){
        this.puntosnormal = puntosnormal;
    }
    
    public void setPuntosdificil(int puntosdificil){
        this.puntosdificil = puntosdificil;
    }
    
    // toString
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntosfacil=" + puntosfacil + ", puntosnormal=" + puntosnormal + ", puntosdificil=" + puntosdificil + '}';
    }   
}
