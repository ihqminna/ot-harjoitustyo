
package partypeli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        player = new Player("TestName");
    }
    
    @Test
    public void newPlayerCreation(){
        assertEquals("TestName", player.getName());
    }
}
