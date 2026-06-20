package Com.DemoWebShop_GenericUtility;

public interface FrameworkConstants {
	
	JavaUtility jutil=new JavaUtility();
	
	String propertyFilePath ="./src/test/resources/Test Data/commonData.properties";
	
	String excelFilePath ="./src/test/resources/Test Data/AddressTestData.xlsx";
	
	String ScreenshotPath="./Screenshots/"+jutil.dateAndTime()+".png";
	
	String extendReportPath="./Reports/"+jutil.dateAndTime()+".html";
	


}
