package unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wicampusano on 9/1/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:unit/applicationContext.xml")
@TestExecutionListeners({SysOutTestExecutionListener.class})
public class TestExecutionListenerTest {

    @Test
    public void someTest() {
        System.out.println("Executing someTest");
    }

    @Test
    public void someOtherTest() {
        System.out.println("Executing someOtherTest");
    }
}
