package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver webDriver;
    /**
     * 每个方法执行前，先加载webdriver驱动
     */
    @BeforeMethod
    public void beforeMethod(){
        //设置webdriver的路径
        System.setProperty("webdriver.chrome.driver","D:\\anzhuang\\chrome\\chromedriver.exe");
        //创建一个chromedriver对象
        webDriver = new ChromeDriver();
    }
    /**
     * 关闭浏览器进程
     */
    @AfterMethod
    public void quitBrowser(){
        webDriver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
       LoginTest.login(webDriver,"wo949776130","wo06100155");
       //显示等待
        new WebDriverWait(webDriver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String text = webDriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");

       // 修改xpath的值：     .//*[@id='nerror']/div[2]
    }

    public static void login(WebDriver webDriver,String email,String password){
        webDriver.get("https://mail.163.com/");
        webDriver.findElement(By.id("lbNormal")).click();
        WebElement iframe = webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div[3]/div[1]/div[1]/iframe"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }
}
