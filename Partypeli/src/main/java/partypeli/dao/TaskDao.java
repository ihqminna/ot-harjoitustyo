package partypeli.dao;

import java.sql.*;
import java.util.ArrayList;
import partypeli.domain.Task;
/**
 *
 * @author ihqminna
 */
public class TaskDao {
    private String url;
    private Connection connection;
    
    
    public TaskDao() throws SQLException {
        this.url = "jdbc:sqlite:partypeli.db";
        this.connection = null;
    }
    
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(this.url);
        }
        return connection;
    }

    
    public ArrayList<Task> getQuestions (int dif) throws SQLException, ClassNotFoundException {
        getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Tasks WHERE Drinking = False AND Difficulty <=" + dif);
        ArrayList<Task> tasks = new ArrayList();
        
        while (rs.next()) {
            tasks.add(new Task(rs.getString("Task"), rs.getBoolean("Drinking")));
        }
        
        stmt.close();
        rs.close();
        connection.close();
        return tasks;        
    }
    
    /*public ArrayList<Task> getDrinkingTasks(int dif) throws SQLException {
        Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Tasks WHERE Drinking = True AND Difficulty <=" + dif);
        ArrayList<Task> tasks = new ArrayList();
        
        while (rs.next()) {
            tasks.add(new Task(rs.getString("Task"), rs.getBoolean("Drinking")));
        }
        
        stmt.close();
        rs.close();
        return tasks;
    }*/
}