package selenium3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
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
     * 执行JS代码操作浏览器
     */
    @Test
    public void getAttribute() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"abcd\")");
        Thread.sleep(5000);
    }
}
