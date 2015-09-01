package unit;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by wicampusano on 9/1/2015.
 */
public class SysOutTestExecutionListener implements TestExecutionListener{

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        System.out.println("before for class = "+ testContext.getTestClass());
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        System.out.println("in prepare test instance = "+ testContext.getTestInstance());
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        System.out.println("before test method = "+ testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        System.out.println("after test method = "+ testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println("after test class = "+ testContext.getTestClass());
    }
}
