
package partypeli.domain;

public class Task {
    public String task;
    public int dif;
    public boolean drinking;
    
    public Task(String task, int dif, boolean drinking) {
        this.task = task;
        this.dif = dif;
        this.drinking = drinking;
    }

    public Task(String task, boolean drinking) {
        this.task = task;
        this.dif = 0;
        this.drinking = drinking;
    }
    
    public String getTask() {
        return this.task;
    }
    
    public int getDifficulty() {
        return this.dif;
    }
    
    public boolean getDrinking() {
        return this.drinking;
    }
}
