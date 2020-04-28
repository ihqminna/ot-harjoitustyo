
package partypeli.dao;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import partypeli.domain.Task;

/**
 *
 * Luokka tarjoaa yhteyden tehtävät sisältävään tiedostoon.
 */
public class TaskFileDao {

    /**
     *
     */
    public ArrayList<Task> questions;

    /**
     *
     */
    public ArrayList<Task> drinkingTasks;
    
    /**
     *
     */
    public TaskFileDao() {
        this.questions = new ArrayList();
        this.drinkingTasks = new ArrayList();
    }
    
    /**
     * Metodi palauttaa kaikki tiedoston kysymykset.
     * 
     * @return kaikki kysymykset
     */
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
    
    /**
     * Metodi hakee kaikki tiedoston juomatehtävät
     * 
     * @return kaikki juomatehtävät
     */
    public ArrayList<Task> getDrinkingTasks() {
        
        return this.drinkingTasks;
    }
}
