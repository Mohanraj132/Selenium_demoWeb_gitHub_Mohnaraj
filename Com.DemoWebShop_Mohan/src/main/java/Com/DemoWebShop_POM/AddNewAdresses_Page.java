package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAdresses_Page {

	public AddNewAdresses_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "Address_FirstName")
	private WebElement firstNameTextField;
	
	@FindBy(id = "Address_LastName")
	private WebElement LastNameTextField;
	
	@FindBy(id = "Address_Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Address_CountryId")
	private WebElement countryDropdown;
	
	@FindBy(id = "Address_City")
	private WebElement cityTextField;
	
	@FindBy(id = "Address_Address1")
	private WebElement Address1TextField;
	
	@FindBy(id = "Address_Address2")
	private WebElement Address2TextField;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement zipPostalCodeTextField;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement phoneNumberTextField;
	
	@FindBy(id = "Address_FaxNumber")
	private WebElement faxNumberTextField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton;

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddress1TextField() {
		return Address1TextField;
	}

	public WebElement getAddress2TextField() {
		return Address2TextField;
	}

	public WebElement getZipPostalCodeTextField() {
		return zipPostalCodeTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getFaxNumberTextField() {
		return faxNumberTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	
	
	}

