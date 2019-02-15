/**
 *
 * @author Juan Padilla Ceballos
 */

package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionDao {
   
    // Establecemos la conexion con la BBDD
    
    Connection conexion;
    
    // Creacion de Metodos

    // Metodo para comprobar si el jugador existe en la BBDD
    
    public boolean existeJugador(Jugador j) throws SQLException {
        String select = "Select * from jugador where nombre='" + j.getNombre() + "'";
        
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        boolean existe = false;
      
        //Si el ResultSet nos devuelve algún valor es que el jugador existe
        
        if(rs.next()){
            existe = true;
        }
        
        rs.close();
        st.close();
        
        return existe;
    }
    
    // Metodo para insertar un jugador
    
     public void insertarJugador(Jugador j) throws SQLException {
        if (existeJugador(j)) {
            
        } else {
            //Si el jugador no existe lo creamos
            
            //Creamos la sentencia para insertar el jugador en SQL
            
            String insert = "Insert into jugador (nombre, puntosfacil, puntosnormal, puntosdificil) values (?,?,?,?)";
            
            //Creamos el PreparedStatement para indicarle que valores ocuparán las posiciones que le pasamos.
            
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, j.getNombre());
            ps.setInt(2, j.getPuntosfacil());
            ps.setInt(3, j.getPuntosnormal());
            ps.setInt(4, j.getPuntosdificil());
            
            //Ejecutamos la consulta
            
            ps.executeUpdate();
            //Cerramos nuestro PreparedStatement
            
            ps.close();
        }
    }
    
    // Metodo para modificar la puntuacion en el modo facil
     
    public void modificarPuntosFacil(Jugador j) throws SQLException{
        String update = "update jugador set puntosfacil = ? where nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, j.getPuntosfacil());
        ps.setString(2, j.getNombre());
        ps.executeUpdate();
        ps.close();
    }
    
    // Metodo para modificar la puntuacion en el modo normal
    
     public void modificarPuntosNormal(Jugador j) throws SQLException{
        String update = "update jugador set puntosnormal = ? where nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, j.getPuntosnormal());
        ps.setString(2, j.getNombre());
        ps.executeUpdate();
        ps.close();
    }
     
    // Metodo para modificar la puntuacion en el modo dificil
     
    public void modificarPuntosDificil(Jugador j) throws SQLException{
        String update = "update jugador set puntosdificil = ? where nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1, j.getPuntosdificil());
        ps.setString(2, j.getNombre());
        ps.executeUpdate();
        ps.close();
    }
    
    // Metodo para mostrar la lista de jugadores con los puntos obtenidos
    
    public ArrayList<String> listaJugadores() throws Exception {
	ArrayList<String> listaJugadores = new ArrayList<String>();
	String query = "select * from jugador;";
	Statement stmt = null;
	ResultSet rs = null;
            try {
		stmt = conexion.createStatement();
		rs = stmt.executeQuery(query);
                    while(rs.next()){
			listaJugadores.add(rs.getString(1)+ "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4) + "  ");
			}
		} catch (SQLException e) {}	
        rs.close();
        stmt.close();
		
	return listaJugadores;
    }
    
    // Creacion de los metodos para conectar y desconectar con la BBDD
    
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/HundirLaFlota"; //Conexión con el driver JDBC
        String user = "root";
        String pass = "";
        conexion = (Connection) DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
}
