package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class RegisterTest {
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

    /**
     * 注册163网站
     */
    @Test
    public void register() throws InterruptedException {
        webDriver.get("https://mail.163.com/");
        webDriver.findElement(By.id("lbNormal")).click();
        WebElement iframe = webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div[3]/div[1]/div[1]/iframe"));
        webDriver.switchTo().frame(iframe);
        //点击注册按钮
        webDriver.findElement(By.id("changepage")).click();
        //获取当前页面的句柄
        String handle = webDriver.getWindowHandle();
        //获取当前浏览器的全部句柄
        //转交页面的控制权
        for(String handles : webDriver.getWindowHandles()){
            if(handles.equals(handle))
                continue;
            webDriver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis()/100);
        webDriver.findElement(By.id("nameIpt")).sendKeys(time+"abc");
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("1234567");
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("1234567");
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("123");
        webDriver.findElement(By.id("mainAcodeIpt")).sendKeys("45679");
        webDriver.findElement(By.id("mainRegA")).click();
        Thread.sleep(Long.parseLong("2000"));
        String text = webDriver.findElement(By.xpath("/html/body/section[1]/div/div[2]/div[3]/dl[4]/dd/div[3]/span")).getText();
        Assert.assertEquals(text,"  请填写正确的手机号");
        Thread.sleep(5000);
    }
}
