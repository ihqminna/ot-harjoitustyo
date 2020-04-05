
package partypeli;

import java.util.*;
import java.sql.*;

public interface Dao <Task, Integer>{
    void create(Task task) throws SQLException;
    Task read(Integer i) throws SQLException;
    Task update(Task task) throws SQLException;
    void delete(Integer i) throws SQLException;
    List<Task> list() throws SQLException;
}
