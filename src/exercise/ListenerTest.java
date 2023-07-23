package exercise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	@Override
	public void onFinish(ITestContext arg0) {}
	
	@Override
	public void onStart(ITestContext arg0) {}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("The name of the testcase failed is: " + arg0.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult arg0) {}
	
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName() + " test case started");
	}
	
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("The name of the testcase passed is: " + arg0.getName());
	}
}
