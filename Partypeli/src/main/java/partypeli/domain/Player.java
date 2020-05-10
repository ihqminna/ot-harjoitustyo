
package partypeli.domain;

/**
 * Class members are the individual players of a game.
 */

public class Player {
    public String name;
    
    public Player(String givenName) {
        this.name = givenName;
    }
    
    public String getName() {
        return this.name;
    }
}
