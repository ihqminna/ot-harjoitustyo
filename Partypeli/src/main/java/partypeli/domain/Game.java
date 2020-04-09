package partypeli.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import partypeli.dao.TaskDao;

public class Game {
    public ArrayList<Player> players;
    public ArrayList<Task> tasks;
    public int difficulty;
    public int drinkingAmount;
    public int turn;
    public TaskDao taskdao;
    public Random rnd;
        
    public Game() {
        this.players = new ArrayList();
        this.turn = 0;
        this.rnd = new Random();
    }
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    
    public void setDifficulty(int dif) {
        this.difficulty = dif;
    }
    
    public void setDrinkingAmount(int drink) {
        this.drinkingAmount = drink;
    }
    
    public String getNextPlayerName() {
        String player = players.get(this.turn).getName();
        
        if (this.turn < (players.size() - 1)) {
            this.turn += 1;
        } else {
            this.turn = 0;
        }
        
        return player;
    }
    
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
    
    public int numberOfPlayers() {
        return players.size();
    }
    
    public int numberOfTasks() {
        return this.tasks.size();
    }
                
    public void deletePlayers() {
        players.clear();
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    public int getDrinkingAmount() {
        return this.drinkingAmount;
    }
    
    public void makeTaskList() throws SQLException {
        if (this.drinkingAmount == 0){
            makeTaskListWODrinking();
        } else {
            makeTaskListWDrinking();
        }
    }
    
    public void makeTaskListWODrinking() throws SQLException {
        this.tasks.addAll(taskdao.getQuestions(this.difficulty));
    }
    
    public void makeTaskListWDrinking() throws SQLException {
        ArrayList<Task> questions = new ArrayList();
        ArrayList<Task> drinkingTasks = new ArrayList();
        questions = taskdao.getQuestions(this.difficulty);
        drinkingTasks = taskdao.getDrinkingTasks(this.difficulty);
        Collections.shuffle(questions);
        Collections.shuffle(drinkingTasks);
        
        if (this.drinkingAmount == 1) {
            makeTaskListWLittleDrinking(questions, drinkingTasks);
        } else if (this.drinkingAmount == 2) {
            makeTaskListWLotDrinking(questions, drinkingTasks);
        }
    }
    
    public void makeTaskListWLittleDrinking(ArrayList<Task> questions, ArrayList<Task> drinkingTasks) {
        int thirdOfQuestions = questions.size();
        if (thirdOfQuestions < drinkingTasks.size()){
            drinkingTasks = new ArrayList(drinkingTasks.subList(0, thirdOfQuestions));
        } else if (thirdOfQuestions > drinkingTasks.size()) {
            
        }
        this.tasks.addAll(questions);
        this.tasks.addAll(drinkingTasks);
    }
    
    public void makeTaskListWLotDrinking(ArrayList<Task> questions, ArrayList<Task> drinkingtasks) {
        
    }
    
    public String getNextTask() {
        String task = tasks.get(rnd.nextInt(tasks.size())).getTask();
        return task;
    }
}