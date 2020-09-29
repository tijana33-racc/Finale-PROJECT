package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getInputName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[2]/div[1]/fieldset/input"));
	}

	public WebElement getPhoneNo() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getAddres() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public WebElement getCountry() {
		return this.driver.findElement(By.id("user_country_id"));
	}

	public WebElement getCtate() {
		return this.driver.findElement(By.id("user_state_id"));
	}

	public WebElement getCity() {
		return this.driver.findElement(By.id("user_city"));
	}

	public WebElement getSaveProfile() {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[5]/div/fieldset/input"));
	}

	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));

	}

	public WebElement getNewPassword() {
		return this.driver.findElement(By.name("new_password"));

	}

	public WebElement getComnfirmPassword() {
		return this.driver.findElement(By.name("conf_new_password"));

	}
	public WebElement getSaveNewPassword() {
		return this.driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[4]/fieldset/input"));

	}
	public WebElement getUploadPhoto() {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", this.getUploadPhoto()); 

		return this.driver.findElement(By.className("ion-camera")); 
		
	}
	public WebElement getRemovePhoto() { 
		return this.driver.findElement(By.className("ion-android-close")); 
	}
	public void removePhoto() { 
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", this.getRemovePhoto()); 
	}
	
}
