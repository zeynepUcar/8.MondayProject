import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNg {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void init(){
        System.setProperty( "webdriver.chrome.driver", "/Users/AKMERCAN/Desktop/Selenium/Chrome Driver/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://test-basqar.mersys.io/" );
        driver.manage().window().maximize();
        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( "admin" );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

    }
    @BeforeMethod
    public void waiting(){
        wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
    }

    @Test
    public void main() throws InterruptedException {

        //click on budget
        driver.findElement(By.xpath("//span[text()='Budget']")).click();

        //click on Setup
        driver.findElement(By.xpath("(//span[text()='Setup'])[5]")).click();

        //clicl on Cost Center
        driver.findElement(By.xpath("//span[text()='Cost Centers']")).click();

        //click on plus icon
        driver.findElement(By.xpath("//*[@tooltip='COST_CENTER.TITLE.ADD']")).click();

        //fill all the inputs


        WebElement fillTheName  = driver.findElement(By.xpath("//input[@id='ms-text-field-0']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        String name = "Bodrum";
        fillTheName.sendKeys(name);

        WebElement fillTheCode  = driver.findElement(By.xpath("//input[@id='ms-text-field-1']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        String code= "678uy";
        fillTheCode.sendKeys(code);


        WebElement clickTheType  = driver.findElement(By.xpath("//*[@id='mat-select-1']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        clickTheType.click();

        //choose from dropdown
        WebElement choiseOfDropdown = driver.findElement(By.xpath("//span[text()=' Personal ']"));
        String text = choiseOfDropdown.getText();
        choiseOfDropdown.click();

        WebElement orderNumber  = driver.findElement(By.xpath("//input[@id='ms-text-field-2']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        orderNumber.clear();
        String orderNum = "17";
        orderNumber.sendKeys(orderNum);

        //click on the constants

        driver.findElement(By.xpath("//div[@id='mat-tab-label-0-1']")).click();

        //fill the input on constants

        WebElement clickTheKey  = driver.findElement(By.xpath("//input[@id='ms-text-field-3']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        clickTheKey.click();
        clickTheKey.sendKeys("sultan");

        WebElement clickTheValue  = driver.findElement(By.xpath("//input[@id='ms-text-field-4']"));
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
        clickTheValue.click();
        clickTheValue.sendKeys("gunabakan");

        //click on add button
        WebElement addButton = driver.findElement(By.xpath("//span[text()='Add']"));
        Thread.sleep(1500);
        addButton.click();

        //click on save button
        WebElement save= driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
        Thread.sleep(1500);
        save.click();

        //verify all the inputs

        String textOfName = driver.findElement(By.xpath("//td[text()='Bodrum']")).getText();
        Assert.assertEquals(name,textOfName);

        String textOfCode = driver.findElement(By.xpath("//td[text()='678uy']")).getText();
        Assert.assertEquals(code,textOfCode);

        String textOfDropDown = driver.findElement(By.xpath("(//td[@role='gridcell'])[4]")).getText();
        Assert.assertEquals(text,textOfDropDown);

        String textOfOrder = driver.findElement(By.xpath("//td[text()='17']")).getText();
        Assert.assertEquals(orderNum,textOfOrder);


    }

}
