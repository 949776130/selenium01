package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WinTest {
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

    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }

    /**
     * 当开发新的窗口时，需要把句柄值传递到新开的窗口
     */
    @Test
    public void winTest(){
        //获取当前窗口的句柄值
        String windowHandle = webDriver.getWindowHandle();
        //定位到要点击新窗口的链接文字，并点击
        webDriver.findElement(By.linkText("新闻")).click();
        //当只开了两个窗口时，获取全部窗口句柄数组，并逐一遍历不一样的句柄，就转交driver
        for(String handle : webDriver.getWindowHandles()){
            if(windowHandle.equals(handle))
                continue;
            webDriver.switchTo().window(handle);//将driver转交给新开的窗口句柄
        }
    }
}
