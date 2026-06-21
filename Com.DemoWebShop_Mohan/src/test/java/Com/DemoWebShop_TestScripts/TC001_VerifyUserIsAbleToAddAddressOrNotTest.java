package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddNewAdresses_Page;
import Com.DemoWebShop_POM.Adresses_Page;

public class TC001_VerifyUserIsAbleToAddAddressOrNotTest extends BaseTest {
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {

		webDriverUtility.javaScriptScrollTillElement(driver, homePage.getAddressesLink());
		homePage.getAddressesLink().click();

		Adresses_Page adressesPage = new Adresses_Page(driver);
		webDriverUtility.javaScriptScrollTillElement(driver, adressesPage.getAddNewButton());
		adressesPage.getAddNewButton().click();

		AddNewAdresses_Page addNewAddressesPage = new AddNewAdresses_Page(driver);
		addNewAddressesPage.getFirstNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 0));
		addNewAddressesPage.getLastNameTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddressesPage.getEmailTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 2));

		webDriverUtility.selectByVisibleText(addNewAddressesPage.getCountryDropdown(),
				fileutility.readDataFromExcelFile("Sheet1", 1, 3));

		addNewAddressesPage.getCityTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddressesPage.getAddress1TextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddressesPage.getAddress2TextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddressesPage.getZipPostalCodeTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 7));
		addNewAddressesPage.getPhoneNumberTextField().sendKeys(fileutility.readDataFromExcelFile("Sheet1", 1, 8));

		addNewAddressesPage.getSaveButton().click();
		System.out.println("VerifyUserIsAbleToAddAddressOrNotTest");

		Thread.sleep(3000);
		webDriverUtility.WebPageScreenShot(driver);

	}

}
