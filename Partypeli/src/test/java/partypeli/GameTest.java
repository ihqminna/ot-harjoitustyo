
package partypeli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class GameTest {
    Player player1;
    Player player2;
    ArrayList <Player> players;
    Game game;
    
    public GameTest() {
    }
    
    @Before
    public void setUp() {
        player1 = new Player("matthew");
        player2 = new Player("barnett");
        players = new ArrayList();
        players.add(player1);
        players.add(player2);
        game = new Game(players);
    }

    @Test
    public void gameIsSet(){
        assertEquals("matthew, barnett", game.getPlayers());
    }
    
}
