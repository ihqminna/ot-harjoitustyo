package partypeli.domain;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players;
    public int difficulty;
    public int drinkingAmount;
    public int turn;
        
    public Game() {
        this.players = new ArrayList();
        this.turn = 0;
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
    
    public void deletePlayers() {
        players.clear();
    }
}