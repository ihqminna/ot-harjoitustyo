package partypeli;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players;
    public int difficulty;
    public int drinkingAmount;
        
    public Game(){
        this.players = new ArrayList();
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    public void setDifficulty(int dif){
        this.difficulty = dif;
    }
    
    public void setDrinkingAmount(int drink){
        this.drinkingAmount = drink;
    }
    
    public Player getPlayer(int i){
        Player player = players.get(i);
        return player;
    }
    
    public String getNames(){
        String names = "";
        for (int i = 0; i < players.size(); i++){
            names = names + players.get(i).getName();
            if (i < (players.size() -1)){
                names = names + ", ";
            }
        }
        return names;
    }
    
    public int numberOfPlayers(){
        return players.size();
    }
    
    public void deletePlayers(){
        players.clear();
    }
    
    public ArrayList<Player> getPlayers(){
        return players;
    }
}