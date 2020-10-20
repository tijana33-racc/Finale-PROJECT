package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
    public WebElement getPopUp() { 
    	return this.driver.findElement(By.className("location-selector")); 
    }
    public WebElement getclose() { 
    	 return this.driver.findElement(By.className("close-btn close-btn-white"));
    }
    public WebElement getKeyword() {
    	return this.driver.findElement(By.xpath("//*[@id='locality_keyword']")); 
    }
    public WebElement getLocationItem(String locationName) {
    	return this.driver.findElement(By.xpath("//li/a[contains(text(), \'" + locationName + "\')]"));
    }
    public WebElement getLocationInput() {
    	return this.driver.findElement(By.xpath("//*[@id='location_id']"));
    }
    public WebElement getSubmit() {
    	return this.driver.findElement(By.xpath("//*[@name='btn_submit']")); 
    }
    public void openPopUp() { 
    	this.getPopUp().click();
    }
    public void setLocation(String locationName) { 
    	this.getKeyword().click();
    	String v= this.getLocationInput().getAttribute("data-value");
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), v); 
    	js.executeScript("arguments[0].click()", this.getLocationInput());

    }
    public WebElement getClose() {
		return this.driver.findElement(By.xpath("//*[@id=\"location-popup\"]/div/div/div/div/a")); 
    	
    }
    public void closePopUp() {
    	this.getClose().click();
    }
    
}
