package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void WebPageScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameworkConstants.ScreenshotPath);
		FileHandler.copy(temp, dest);
	}

	public void webElementScreenshot(WebElement element) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameworkConstants.ScreenshotPath);
		FileHandler.copy(temp, dest);	
		
	}
	
	public void selectByVisibleText(WebElement dropDownAddress,String text) {
		
		Select sel=new Select(dropDownAddress);
		sel.selectByVisibleText(text);
		
		
	}
	
	public void javaScriptScrollTillElement(WebDriver driver, WebElement  element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
public void javaScriptClick(WebDriver driver, WebElement  element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	
	
}
}
