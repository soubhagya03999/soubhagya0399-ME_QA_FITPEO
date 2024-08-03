package soubhagya0399.ME_QA_FITPEO;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * The ListenersClass implements the ITestListener interface from TestNG to provide custom actions on test events.
 */
public class ListenersClass implements ITestListener {

    /**
     * This method is invoked when a test case starts.
     *
     * @param result The result of the test.
     */
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase Start : " + result.getName());
        System.out.println("************************************************************************************************************");
    }

    /**
     * This method is invoked when a test case finishes successfully.
     *
     * @param result The result of the test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase End : " + result.getName());
        System.out.println("************************************************************************************************************");
    }

    /**
     * This method is invoked when a test case fails.
     *
     * @param result The result of the test.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("************************************************************************************************************");
        System.out.println("TestCase Failed : " + result.getName());
        System.out.println("************************************************************************************************************");
    }
}
