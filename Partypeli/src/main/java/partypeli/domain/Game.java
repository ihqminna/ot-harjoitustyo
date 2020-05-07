package partypeli.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import partypeli.dao.TaskDao;

/**
 * Class is one game, which includes players and the tasks with chosen difficulty and amount of drinking tasks.
 * 
 */

public class Game {
    public ArrayList<Player> players;
    public ArrayList<Task> tasks;
    public ArrayList<Task> drinkingTasks;
    public ArrayList<Task> questions;
    public int difficulty;
    public int drinkingAmount;
    public int turn;
    public TaskDao taskdao;
    public Random rnd;
        
    public Game() throws ClassNotFoundException, SQLException {
        this.players = new ArrayList();
        this.tasks = new ArrayList();
        this.drinkingTasks = new ArrayList();
        this.questions = new ArrayList();
        this.turn = 0;
        this.rnd = new Random();
        this.taskdao = new TaskDao();
    }
    
    /**
     * Metodi lisää pelaajan peliin.
     * 
     * @param Pelaaja
     */
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    
    public void setDifficulty(int dif) {
        this.difficulty = dif;
    }
    
    public void setDrinkingAmount(int drink) {
        this.drinkingAmount = drink;
    }
    
    /**
     * Metodi hakee seuraavan pelaajan nimen.
     * 
     * @return seuraavan pelaajan nimi merkkijonona
     */
    
    public String getNextPlayerName() {
        String player = players.get(this.turn).getName();
        
        if (this.turn < (players.size() - 1)) {
            this.turn += 1;
        } else {
            this.turn = 0;
        }
        return player;
    }
    
    /**
     * Method sets players' names as a string.
     * 
     * @return players' names as a string
     */
    
    public String getNames() {
        String names = "";
        for (int i = 0; i < players.size(); i++) {
            names = names + players.get(i).getName();
            if (i < (players.size() - 1)) {
                names = names + ", ";
            }
        }
        return names;
    }
    
    /**
     * Method gets the number of players.
     * @return number of players
     */
    
    public int numberOfPlayers() {
        return players.size();
    }

    /**
     * Method removes all the players from the list.
     */
                
    public void deletePlayers() {
        players.clear();
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public int getDrinkingAmount() {
        return this.drinkingAmount;
    }
    
    /**
     *Method uses Dao to get tasks and calls for other methods if the amount of drinking tasks is set.
     */
    
    public void makeTaskList() throws SQLException, ClassNotFoundException {
        //this.drinkingTasks.addAll(taskdao.getDrinkingTasks(this.difficulty));
        //Collections.shuffle(this.drinkingTasks);
        this.questions.addAll(taskdao.getQuestions(this.difficulty));
        Collections.shuffle(this.questions);
        if (this.drinkingAmount == 2) {
            makeTaskListLotOfDrinking();
        } else if (this.drinkingAmount == 1) {
            makeTaskListLittleOfDrinking();
        } else if (this.drinkingAmount == 0) {
            this.tasks.addAll(this.questions);
        }
    }
    
    /**
     * Method chooses the tasks so that half of those are drinking tasks and the other half questions.
     */

    public void makeTaskListLotOfDrinking() {
        int i = 0;
        while (i < this.drinkingTasks.size() && i < this.questions.size()) {
            this.tasks.add(this.drinkingTasks.get(i));
            this.tasks.add(this.questions.get(i));
            i++;
        }
    }
    
    /**
     * Method chooses the tasks so that third of those are drinking tasks.
     */
    
    public void makeTaskListLittleOfDrinking() {
        int i = 0;
        int j = this.questions.size() - 1;
        while (i < this.drinkingTasks.size() && i < (this.questions.size() / 2)) {
            this.tasks.add(this.drinkingTasks.get(i));
            this.tasks.add(this.questions.get(i));
            this.tasks.add(this.questions.get(j));
            i++;
            j--;
        }
    }
    
    /**
     * Method chooses a random task.
     * 
     * @return random question or drinking task
     */
    
    public String getRandomTask() {
        String task = tasks.get(rnd.nextInt(tasks.size())).getTask();
        return task;
    }
}