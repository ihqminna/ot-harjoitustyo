
package partypeli.domain;
;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for class Task.
 * @author ihqminna
 */

public class TaskTest {
    Task task;
    
    public TaskTest() {
    }
 
    @Before
    public void setUp() {
        task = new Task("test task");
    }

    @Test
    public void taskAdded() {
        assertEquals("test task", task.getTask());
    }
    
}
