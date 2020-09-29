package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
public WebElement getMsg() { 
	return this.driver.findElement(By.className("system_message alert alert--success")); 
}
public String AlertMsg() { 
	return this.getMsg().getText(); 
}
public void MessageDissapear() {
	WebElement element = this.driver.findElement(By.xpath(" //*[contains(@class, 'system_message')]")); 
	wait.until(ExpectedConditions.attributeToBe(element, "style", "\"display: none;\"")); 
}

}
