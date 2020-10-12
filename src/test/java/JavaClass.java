import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaClass {

    public WebDriver driver;
    @Before
    public void setUp() {
        //open browser method
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahil\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();//maximise browser
        driver.get("http://thedemosite.co.uk/");//launch url
        driver.manage().deleteAllCookies();//delete cookies
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);//pageload timeouts
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//imp waits
    }

    @Test
    public void addUser(){
        String title = driver.getTitle();
        Assert.assertEquals(title,  "FREE example PHP code and online MySQL database - example username password protected site");
        driver.findElement(By.linkText("3. Add a User")).click();
        String addausertext =driver.findElement(By.xpath("//p[@align='center']//big")).getText();
        Assert.assertEquals(addausertext,"3. Add a User");
        driver.findElement(By.name("username")).sendKeys("fdgghgfhgf");
        driver.findElement(By.name("password")).sendKeys("dfgdfg");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        }

     @After
    public void tearDown(){
        driver.quit();
     }






}
