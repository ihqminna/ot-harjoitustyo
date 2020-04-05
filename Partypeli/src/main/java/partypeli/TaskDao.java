
package partypeli;

import java.util.*;
import java.sql.*;

public class TaskDao implements Dao<Task, Integer> {

    @Override
    public void create(Task task) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // lisää task tietokantaan
    }

    @Override
    public Task read(Integer i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // lue task
    }

    @Override
    public Task update(Task task) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // muokkaa taskia
    }

    @Override
    public void delete(Integer i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // poista task
    }

    @Override
    public List<Task> list() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // lue taskit listalle
    }
    
}
