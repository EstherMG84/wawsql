
package DataBase;

import Batallas.TopScore;
import Componentes.Personas.General;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Esther Manresa
 */
public class MySQLConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/waw";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private final Connection connection = initConnection();
    
    private static MySQLConnection instace = new MySQLConnection();
    
    private MySQLConnection(){
        
    }
    
    public static MySQLConnection getInstance(){
        return instace;
    }
    
    private static Connection initConnection() {
        Connection connection = null;
        try {
            // Registra el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
    
    public List<General> getGenerales(){
        List<General> listaGenerales = new ArrayList<>();
        try {
            PreparedStatement  statement = connection.prepareStatement("SELECT * FROM GENERALES");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                 
                General general = new General();
                    
                general.setId(resultSet.getInt("ID"));
                general.setNombre(resultSet.getString("NOMBRE"));
                general.setAtaque(resultSet.getInt("ATAQUE"));
                general.setDefensa(resultSet.getInt("DEFENSA"));
                general.setSalud(resultSet.getInt("SALUD"));
                    
                System.out.println(general.toString());
                    
                listaGenerales.add(general);
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaGenerales;
    }

    public void saveGeneral(General general) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO GENERALES (NOMBRE, ATAQUE, DEFENSA, SALUD) VALUES (?, ?, ?, ?)");
            
            statement.setString(1, general.getNombre());
            statement.setInt(2, general.getAtaque());
            statement.setInt(3, general.getDefensa());
            statement.setInt(4, general.getSalud());
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public General getRandomGeneral(){
        General general = new General();
        try {
            PreparedStatement  statement = connection.prepareStatement("SELECT * FROM generales ORDER BY RAND() LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()){
                    
                general.setId(resultSet.getInt("ID"));
                general.setNombre(resultSet.getString("NOMBRE"));
                general.setAtaque(resultSet.getInt("ATAQUE"));
                general.setDefensa(resultSet.getInt("DEFENSA"));
                general.setSalud(resultSet.getInt("SALUD"));
                    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return general;
    }

    public List<TopScore> getTopScores(){
        List<TopScore> listaScores = new ArrayList<>();
        try {
            PreparedStatement  statement = connection.prepareStatement("SELECT * FROM TOPSCORES");
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                 
                TopScore score = new TopScore(
                        resultSet.getString("NOMBRE_GENERAL"),
                        resultSet.getString("NOMBRE_EJERCITO"),
                        new java.util.Date(resultSet.getDate("FECHA_BATALLA").getTime())
                );
                    
                listaScores.add(score);
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaScores;
    }
    
    public void saveScore(TopScore score){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO TOPSCORES (NOMBRE_GENERAL, NOMBRE_EJERCITO, FECHA_BATALLA) VALUES (?, ?, ?)");
            
            statement.setString(1, score.getNombreGeneral());
            statement.setString(2, score.getNombreEjercito());
            statement.setDate(3, new java.sql.Date(score.getFechaBatalla().getTime()));
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}