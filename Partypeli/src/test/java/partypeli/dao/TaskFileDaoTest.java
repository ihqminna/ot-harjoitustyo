/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partypeli.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import partypeli.domain.Task;

/**
 *
 * @author ihqminna
 */
public class TaskFileDaoTest {
    TaskFileDao taskfiledao;
    
    public TaskFileDaoTest() {
    }
    
    @Before
    public void setUp() {
        taskfiledao = new TaskFileDao();
    }

    @Test
    public void getQuestionsGetsThem(){
        assertNotNull(taskfiledao.getQuestions());
    }
}
