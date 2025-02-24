package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class AutoUpdate {
	private WebDriver driver;
    private WebDriverWait wait;
    
    private final String EMAIL = "tusharsjadhav60@gmail.com";
    private final String PASSWORD = "JayJay_Shakar1919";
    private final String RESUME_PATH = "E:\\Tushar_Jadhav_QA.pdf"; 
	
	@Given("the user is logged into the Nokri portal")
	public void the_user_is_logged_into_the_nokri_portal() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameField"))).sendKeys(EMAIL);
        driver.findElement(By.id("passwordField")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlContains("homepage")); 
	}

	@Given("the user is on the My Profile page")
	public void the_user_is_on_the_my_profile_page() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a"))).click();
		   
	}

	@When("the user clicks on the Upload Resume button")
	public void the_user_clicks_on_the_upload_resume_button() {
		WebElement parentDiv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lazyAttachCV\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/section")));
        parentDiv.click(); 
        
	}

	@When("selects a valid resume file")
	public void selects_a_valid_resume_file() {
		WebElement uploadButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        uploadButton.sendKeys(RESUME_PATH); 
	}

	@Then("the system should successfully update the resume")
	public void the_system_should_successfully_update_the_resume() {
		System.out.println("Resume updated successfully!");
		driver.quit();
	}

	@When("the user is on the Edit Profile page")
	public void the_user_is_on_the_edit_profile_page() {
		WebElement uploadButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/span/div/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div[1]/em")));
        uploadButton.click();
     }

	@When("clicks on the Save button")
	public void clicks_on_the_save_button() throws InterruptedException {
		WebElement element = driver.findElement(By.id("saveBasicDetailsBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBasicDetailsBtn")));
        saveButton.click();
     }

	@Then("the system should successfully update the profile")
	public void the_system_should_successfully_update_the_profile() throws InterruptedException {
		Thread.sleep(2000);
        String expected = "Today";
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/span/div/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div[2]/div[2]/span/span")));
        String actual = element1.getText();
        Assert.assertEquals(actual, expected, "Text mismatch!");
        System.out.println("Profile updated successfully!");
        driver.quit();
	}

}
