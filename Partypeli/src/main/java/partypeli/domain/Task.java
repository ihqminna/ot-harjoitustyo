
package partypeli.domain;

/**
 * Luokan oliot ovat pelin tehtäviä/kysymyksiä.
 */

public class Task {
    public String task;
    public boolean drinking;
    
    public Task(String task, boolean drinking) {
        this.task = task;
        this.drinking = drinking;
    }
    
    public String getTask() {
        return this.task;
    }
    
    public boolean getDrinking() {
        return this.drinking;
    }
}
