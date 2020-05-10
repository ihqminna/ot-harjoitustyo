
package partypeli.domain;

import java.sql.SQLException;
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
    public void setUp() throws ClassNotFoundException, SQLException {
        game = new Game();
        game.addPlayer(new Player("matthew"));
        game.addPlayer(new Player("barnett"));
    }

    @Test
    public void gameIsSet() {
        assertEquals("matthew, barnett", game.getNames());
    }
    
    @Test
    public void settingDifficulty() {        
        game.setDifficulty(3);
        assertEquals(3, game.getDifficulty());
    }
    
    @Test
    public void deletePlayers() {
        game.deletePlayers();
        assertEquals(0, game.numberOfPlayers());
    }
    
    @Test
    public void correctNumberOfPlayers() {
        assertEquals(2, game.numberOfPlayers());
    }
    
    @Test
    public void getNextName() {
        assertEquals("matthew", game.getNextPlayerName());
        assertEquals("barnett", game.getNextPlayerName());
        assertEquals("matthew", game.getNextPlayerName());
    }
    
    @Test
    public void makesTaskList() throws SQLException, ClassNotFoundException {
        game.setDifficulty(3);
        game.makeTaskList();
        assertNotNull(game.getRandomTask());
    }
}
