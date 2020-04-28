
package partypeli.domain;

/**
 * Luokan oliot muodostavat pelin pelaajat.
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
