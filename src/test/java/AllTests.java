
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author peani371
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
    dao.DaoTest.class,
    gui.ProductEditorTest.class})

public class AllTests {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
