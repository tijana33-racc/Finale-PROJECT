package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {
	LocationPopupPage lpp = new LocationPopupPage(driver, wait);
	LoginPage lp = new LoginPage(driver, wait);
	NotificationSystemPage nsp = new NotificationSystemPage(driver, wait);
	AuthPage ap = new AuthPage(driver, wait);
	ProfilePage pp = new ProfilePage(driver, wait);

	@Test(priority = 0)
	public void testEditProfile() throws InterruptedException {
		driver.navigate().to(baseUrl + "/guest-user/login-form");
		lpp.closePopUp();
		lp.LogIn(this.email, this.password);
		lp.getLoginBtn().click();
		String msg = "Login Successfull";
		
		Assert.assertTrue(lpp.getPopUp().getText().contains(msg),"[ERROR] login is not succeful!" );
		Thread.sleep(5000);
		
		driver.navigate().to(baseUrl + "/member/profile");
		pp.changeProfile("Tijana", "Paunovic", "tijanap@gmail", "063437627", "thissipassword", "Dragise Cvetkovica 3", "Serbia", "Nis", "Naissus");

		pp.getSaveProfile().click();
		String setUp = "Setup Successful";
		Assert.assertTrue(nsp.AlertMsg().contains(setUp), "[ERROR] seting up new account failed!");
		Thread.sleep(5000);

		ap.logOut();
		Thread.sleep(2000);
		String logOut= "Logout Successfull!"; 
		Assert.assertTrue(nsp.AlertMsg().contains(logOut), "[ERROR] logout failed!");

		

	}

	@Test(priority = 5)
	public void testChangeProfileImage() throws IOException, InterruptedException {
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		lpp.closePopUp();
		lp.LogIn(this.email, this.password);
		String login = "Login Successfull";
		Assert.assertTrue(nsp.AlertMsg().contains(login), "[ERROR] login failed");
		this.driver.navigate().to(baseUrl + "/member/profile");
		String path = new File("/images/ja.jpg").getCanonicalPath();
		pp.getUploadPhoto().sendKeys(path);
		Thread.sleep(5000);

		String uploadedImg = "Profile Image Uploaded Successfully";
		Assert.assertTrue(nsp.AlertMsg().contains(uploadedImg), "[ERROR] image uoplaod failed");
		nsp.MessageDissapear();
		Thread.sleep(3000);
		pp.getRemovePhoto(); 
		String imgRemoved = "Profile Image Deleted Successfully"; 
		Assert.assertTrue(nsp.AlertMsg().contains(imgRemoved),"[ERROR] image removal failed" );
		nsp.MessageDissapear();
		Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ap.getLogout()); 
		String logOut= "Logout Successfull!"; 
		Assert.assertTrue(nsp.AlertMsg().contains(logOut), "[ERROR] logout failed!");
		
		
		
		
		

		

	}

}
