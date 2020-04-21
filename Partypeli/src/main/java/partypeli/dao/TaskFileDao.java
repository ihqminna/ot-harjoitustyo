
package partypeli.dao;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import partypeli.domain.Task;

public class TaskFileDao {
    public ArrayList<Task> questions;
    public ArrayList<Task> drinkingTasks;
    
    public TaskFileDao() {
        this.questions = new ArrayList();
        this.drinkingTasks = new ArrayList();
    }
    
    public ArrayList<Task> getQuestions() {
        try (Scanner scanner = new Scanner(new File("tasks.txt"))) {
            
            while (true) {
                String row = scanner.nextLine();
                if (row.equals("")) {
                    break;
                }
                boolean drinking = false;
                if (row.substring(1, 1).equals("1")) {
                    drinking = true;
                }

                Task task = new Task(row.substring(2), drinking);
                this.questions.add(task);                    
                //Task task = new Task(row.substring(2), Integer.parseInt(row.substring(0, 0)), drinking);

            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        return this.questions;
    }
    
    public ArrayList<Task> getDrinkingTasks() {
        
        return this.drinkingTasks;
    }
}
