package unit.environment;

import environment.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by wicampusano on 9/2/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class, initializers = EnvironmentTest.MockPropertyInitializer.class)
public class EnvironmentTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void environment() throws Exception {
        assertEquals("Im a Mock", context.getBean("message"));
    }

    public static class MockPropertyInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

            MutablePropertySources mutablePropertySources = configurableApplicationContext.getEnvironment().getPropertySources();
            MockPropertySource mockPropertySource = new MockPropertySource().withProperty("message", "Im a Mock");

            mutablePropertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, mockPropertySource);
        }
    }
}
