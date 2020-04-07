
package partypeli.domain;

public class Player {
    public String name;
    
    public Player(String givenName) {
        this.name = givenName;
    }
    
    public String getName() {
        return this.name;
    }
}
