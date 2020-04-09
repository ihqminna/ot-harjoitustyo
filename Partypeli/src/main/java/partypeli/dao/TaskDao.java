
package partypeli.dao;

import java.util.*;
import java.sql.*;
import partypeli.domain.Task;

public class TaskDao implements Dao<Task> {
    public ArrayList<Task> questions;
    public ArrayList<Task> drinkingTasks;
    Scanner lukija;

    public TaskDao() throws SQLException {
    }

    public ArrayList<Task> getQuestions(int difficulty) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/partypeli");
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Task WHERE Drinking = ? AND Difficulty < ?");
           
        difficulty += 1;
        stmt.setInt(1, 0);
        stmt.setInt(2, difficulty);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Task task = new Task(rs.getString("Task"), false);
            this.questions.add(task);
        }
        
        stmt.close();
        rs.close();
        connection.close();
        return this.questions;
    }

    public ArrayList<Task> getDrinkingTasks(int difficulty) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:./partypeli", "sa", "");
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Task WHERE Drinking = ? AND Difficulty < ?");
           
        difficulty += 1;
        stmt.setInt(1, 1);
        stmt.setInt(2, difficulty);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Task task = new Task(rs.getString("Task"), true);
            this.drinkingTasks.add(task);
        }
        
        stmt.close();
        rs.close();
        connection.close();
        return this.drinkingTasks;
    }
}
