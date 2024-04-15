package api.utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

		ExtentSparkReporter sparkReporter;
		ExtentReports reports;
		ExtentTest test;
		String repName;
		
		
		  public void onStart(ITestContext context) {
			  //  configureReport();
			  System.out.println("On start method invoked.....");
			  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			  repName = "Test-Report"+timeStamp+".html";
			  
			  sparkReporter= new ExtentSparkReporter(".//reports//repName");
			  sparkReporter.config().setDocumentTitle("RestAssured Automation Project");
		      sparkReporter.config().setReportName("Pet Store User API");
			  sparkReporter.config().setTheme(Theme.DARK);
			  
			  
			  	reports= new ExtentReports();
				reports.attachReporter(sparkReporter);
				
				//add system information/environments info to reports
				reports.setSystemInfo("Machine", "LAPTOP-K26E8UFK");
				reports.setSystemInfo("OS","Windows11");
				reports.setSystemInfo("Envirnment", "QA");
				reports.setSystemInfo("User","Surender");
				reports.setSystemInfo("Application","Pet Store User API");
				
				
			  }

	/*	public void configureReport()
		{
			htmlReporter= new ExtentSparkReporter("ExtentListenerReportDemo.html");
			reports= new ExtentReports();
			reports.attachReporter(htmlReporter);
			
			//add system information/environments info to reports
			reports.setSystemInfo("Machine", "LAPTOP-K26E8UFK");
			reports.setSystemInfo("OS","Windows11");
			
			
			htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
			htmlReporter.config().setReportName("This is my first Report");
			htmlReporter.config().setTheme(Theme.DARK);
			
		}*/

		
		
		  public void onTestSuccess(ITestResult result) {
		  System.out.println("Name of the test method successfully excuted "+result.getName());
		   test=reports.createTest(result.getName());
		   test.createNode(result.getName());
		   test.log(Status.PASS, "Test Passed");
		  }

		
		  public void onTestFailure(ITestResult result) {
		    System.out.println("Name of test method failed:"+result.getName());
		    test=reports.createTest(result.getName());
		    test.createNode(result.getName());
		    test.log(Status.FAIL, "Test Failed");
		    test.log(Status.FAIL, result.getThrowable().getMessage());
		    
		    
		  }
		    
		  
		  public void onTestSkipped(ITestResult result) {
		    System.out.println("Name of test method skipped "+result.getName());
		    test=reports.createTest(result.getName());
		    test.createNode(result.getName());
		    test.log(Status.SKIP, "Test Skipped");
		    test.log(Status.SKIP, result.getThrowable().getMessage());
		  }



		
		 
	
		
		  public void onFinish(ITestContext context) {
		    System.out.println("On Finished method invoked.....");
		    reports.flush();	// it is mandatory to call flush method to ensure information is written it the started reporter. 
		  }

}

