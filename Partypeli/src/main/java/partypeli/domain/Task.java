
package partypeli.domain;

/**
 * Luokan oliot ovat pelin tehtäviä.
 */

public class Task {
    public String task;
    
    public Task(String task) {
        this.task = task;
    }
    
    public String getTask() {
        return this.task;
    }
}
