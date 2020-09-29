package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
public WebElement getLoginBtn() {
	return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li[2]/a")); 
}
public WebElement getEmail() { 
	return this.driver.findElement( By.name("username")); 
}
public WebElement getPassword() { 
	return this.driver.findElement(By.name("password")); 
}
public WebElement getRemaberMe() { 
	return this.driver.findElement(By.name("remember_me")); 
}
public WebElement getLogin() { 
	return this.driver.findElement(By.name("btn_submit")); 
}
public void LogIn( String email, String password) { 
	this.getLoginBtn().click();
	this.getEmail().clear();
	this.getPassword().clear();
	this.getEmail().sendKeys(email);
	this.getPassword().sendKeys(password);
	this.getLogin().click();
}

}
