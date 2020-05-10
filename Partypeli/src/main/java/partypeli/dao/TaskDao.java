package partypeli.dao;

import java.sql.*;
import java.util.ArrayList;
import partypeli.domain.Task;
/**
 * This class connects the game to the database.
 *
 */
public class TaskDao {
    private String url;
    private Connection connection;
    
    
    public TaskDao() throws SQLException {
        this.url = "jdbc:sqlite:partypeli.db";
        this.connection = null;
    }
    
    
    /**
     * Method creates a connection to the database.
     * @return database connection
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            //Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(this.url);
        }
        return connection;
    }
    
    /**
     * Method makes a list of the questions in the database with the chosen or smaller difficulty.
     * @param dif = difficulty of the game
     * @return list of questions for the game
     * @throws SQLException
     * @throws ClassNotFoundException 
     */

    
    public ArrayList<Task> getTasks(int dif) throws SQLException, ClassNotFoundException {
        getConnection();
        Statement stmt = connection.createStatement();
        String difficulty = "difficulty <= " + Integer.toString(dif) + ";";
        ResultSet rs = stmt.executeQuery("SELECT * FROM Tasks WHERE " + difficulty);
        ArrayList<Task> tasks = new ArrayList();
        
        while (rs.next()) {
            tasks.add(new Task(rs.getString("task")));
        }
        
        stmt.close();
        rs.close();
        connection.close();
        return tasks;        
    }
}