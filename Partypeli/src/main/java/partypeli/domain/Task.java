
package partypeli.domain;

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
 
}
