package partypeli;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players;
        
    public Game(ArrayList<Player> playerList){
        ArrayList<Player> players = playerList;
    }
    
    public String getPlayers(){
        String names = "";
        int i=0;
        while(i<players.size()){
            names = names + players.get(i).getName();
            i++;
            if (i<players.size()){
                names = names + ", ";
            }
        }
        
        return names;
    }
    
}
