/**
 *
 * @author Juan Padilla Ceballos
 */

package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainDao {
    
    public static ArrayList<String> listaJugadores;
    public static GestionDao jugadores = new GestionDao();
    
     public static void main(String[] args) throws SQLException, Exception {
      
        Jugador juan = new Jugador ("juan", 0, 0, 0);
        Jugador miguel = new Jugador ("miguel", 0, 0, 0);
        Jugador jose = new Jugador ("jose", 0, 0, 0);
        Jugador maria = new Jugador ("maria", 0, 0, 0);
        Jugador isabel = new Jugador ("isabel", 0 ,0, 0);
        
        // Establecemos conexion con la BBDD
        
        jugadores.conectar();
        
        // Insertamos jugadores
        
         altaJugador(jugadores, juan);
         altaJugador(jugadores, miguel);
         altaJugador(jugadores, jose);
         altaJugador(jugadores, maria);
         altaJugador(jugadores, isabel);
         
        // Modificamos las puntuaciones de los jugadores
        
        // Modo facil
        
        juan.setPuntosfacil(10);
        modificarPuntuacionFacil(jugadores, juan);
        miguel.setPuntosfacil(10);
        modificarPuntuacionFacil(jugadores, miguel);
        jose.setPuntosfacil(10);
        modificarPuntuacionFacil(jugadores, jose);
        maria.setPuntosfacil(10);
        modificarPuntuacionFacil(jugadores, maria);
        isabel.setPuntosfacil(10);
        modificarPuntuacionFacil(jugadores, isabel);
        
        // Modo normal
        
        juan.setPuntosnormal(100);
        modificarPuntuacionNormal(jugadores, juan);
        miguel.setPuntosnormal(100);
        modificarPuntuacionNormal(jugadores, miguel);
        jose.setPuntosnormal(100);
        modificarPuntuacionNormal(jugadores, jose);
        maria.setPuntosnormal(100);
        modificarPuntuacionNormal(jugadores, maria);
        isabel.setPuntosnormal(100);
        modificarPuntuacionNormal(jugadores, isabel);
        
        // Modo dificil
        
        juan.setPuntosdificil(1000);
        modificarPuntuacionDificil(jugadores, juan);
        miguel.setPuntosdificil(1000);
        modificarPuntuacionDificil(jugadores, miguel);
        jose.setPuntosdificil(1000);
        modificarPuntuacionDificil(jugadores, jose);
        maria.setPuntosdificil(1000);
        modificarPuntuacionDificil(jugadores, maria);
        isabel.setPuntosdificil(1000);
        modificarPuntuacionDificil(jugadores, isabel);
        
        // Listado de jugadores y puntuaciones
        
        listaJugadores();
        
        // Realizamos las desconexion
        
        jugadores.desconectar();
        
    }
    
     // Metodo para insertar jugadores
     
     public static void altaJugador (GestionDao jugadores, Jugador j) throws SQLException{
        jugadores.insertarJugador(j);    
     }
     
     // Metodo para modificar puntuacion en modo facil
     
     public static void modificarPuntuacionFacil(GestionDao jugadores, Jugador j) throws SQLException{
        jugadores.modificarPuntosFacil(j);
     }   
        
     // Metodo para modificar puntuacion en modo normal
     
     public static void modificarPuntuacionNormal(GestionDao jugadores, Jugador j) throws SQLException{
        jugadores.modificarPuntosNormal(j);
     }
     
     // Metodo para modificar puntuacion en modo dificil
     
     public static void modificarPuntuacionDificil(GestionDao jugadores, Jugador j) throws SQLException{
        jugadores.modificarPuntosDificil(j);
     }
     
     // Metodo para mostrar los jugadores y sus puntuaciones
     
     public static void listaJugadores () throws Exception{
         
         listaJugadores = MainDao.jugadores.listaJugadores();
            String[] players = new String[listaJugadores.size()];
		for(int i=0;i<listaJugadores.size();i++){
                    System.out.println(listaJugadores.get(i));
		}    
     }
}

    

