import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyStepdefs {
    WebDriver driver;
    Actions actions = new Actions(driver);
    List<WebElement> list = new ArrayList<WebElement>();
    int size = list.size();
    File configFile = new File("test.properties");

    FileInputStream fis;
    Properties properties = new Properties();

    {
        try {
            fis = new FileInputStream(configFile);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @io.cucumber.java.en.Given("^User launch browser$")
    public void userLaunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "pathOfChromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @io.cucumber.java.en.When("^User enter \"([^\"]*)\"$")
    public void userEnter(String element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("xpath")).sendKeys(properties.getProperty(element));

    }

    @io.cucumber.java.en.Then("^User see \"([^\"]*)\"$")
    public void userSee(WebElement element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        element = driver.findElement(By.xpath("xpath"));
        element.isDisplayed();
    }

    @io.cucumber.java.en.When("^User click on \"([^\"]*)\"$")
    public void userClickOn(WebElement element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        element = driver.findElement(By.xpath("xpath"));
        element.click();
    }

    @io.cucumber.java.en.When("^User moves to \"([^\"]*)\"$")
    public void userMovesTo(WebElement element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        element = driver.findElement(By.xpath("xpath"));
        actions.moveToElement(element).build().perform();
    }

    @io.cucumber.java.en.And("^User enters username$")
    public void userEntersUsername() {
        driver.findElement(By.xpath("xpath")).sendKeys(properties.getProperty("Username"));
    }

    @io.cucumber.java.en.And("^User enters password$")
    public void userEntersPassword() {
        driver.findElement(By.xpath("xpath")).sendKeys(properties.getProperty("Password"));
    }

    @io.cucumber.java.en.Then("^Value pulled is displayed$")
    public void valuePulledIsDisplayed() {
    }

    @When("User moves to \"([^\"]*)\" in list and select$")
    public void userMovesToInList(WebElement element) {
        element = driver.findElement(By.xpath("xpath"));
        actions.moveToElement(element).build().perform();
        element.click();
    }

    @And("User drag and drop \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\"")
    public void userDragAndDropFromTo(WebElement source, WebElement destination) {
        source = driver.findElement(By.xpath("xpath"));
        destination = driver.findElement(By.xpath("xpath"));
        actions.dragAndDrop(source, destination);
    }
}
