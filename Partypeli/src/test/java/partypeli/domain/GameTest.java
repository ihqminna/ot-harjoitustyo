
package partypeli.domain;

import partypeli.domain.Player;
import partypeli.domain.Game;
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
        game = new Game();
        game.addPlayer(new Player("matthew"));
        game.addPlayer(new Player("barnett"));
    }

    @Test
    public void gameIsSet(){
        assertEquals("matthew, barnett", game.getNames());
    }
    
}
