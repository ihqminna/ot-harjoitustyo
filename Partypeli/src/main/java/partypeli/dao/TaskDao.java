
package partypeli.dao;

import java.util.*;
import java.sql.*;
import partypeli.domain.Task;

public class TaskDao implements Dao<Task> {
    public ArrayList<Task> questions;
    public ArrayList<Task> drinkingTasks;
    Scanner lukija;

    public TaskDao() throws SQLException {
        this.questions = new ArrayList();
        this.drinkingTasks = new ArrayList();
        
    }

    public ArrayList<Task> getQuestions(int difficulty) throws SQLException {
        String sql = "SELECT * FROM Task WHERE Drinking = " + 0 + "AND Difficulty <= " + difficulty;
        
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:./partypeli");
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
        
            while(rs.next()){
                Task task = new Task(rs.getString("Task"), 0, false);
                this.questions.add(task);
            }              
            stmt.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            Task task = new Task(rs.getString("Task"), 0, true);
            this.drinkingTasks.add(task);
        }
        
        stmt.close();
        rs.close();
        connection.close();
        return this.drinkingTasks;
    }
}
