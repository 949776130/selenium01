package selenium1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CloseQuitBrowser {
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

    @Test
    public void openFireFox(){
        webDriver = new FirefoxDriver();

    }

    @Test
    public void openChrome(){

        webDriver.get("http://www.baidu.com");
    }

    @Test
    public void closeChrome() throws InterruptedException {

        webDriver.get("http://www.baidu.com");
        Thread.sleep(5000);
        webDriver.close();
    }

    @Test
    public void quitChrome() throws InterruptedException {
        webDriver.get("http://www.google.cn/");
        Thread.sleep(3000);
        //浏览器后退
        //driver.navigate().back();
        //Thread.sleep(3000);
        //浏览器前进
        //driver.navigate().forward();
        //Thread.sleep(3000);
        //刷新页面
        webDriver.navigate().refresh();
        Thread.sleep(3000);
        //driver.close();
        webDriver.quit();
    }

    /**
     * 窗口的显示大小 将窗口最大化
     * @throws InterruptedException
     */
    @Test
    public void windowTest() throws InterruptedException {
        //创建一个对象，设置窗口的显示大小
        Dimension dimension = new Dimension(300, 300);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //将窗口最大化
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
         webDriver.quit();
    }

    /**
     * 校验当前网址是不是百度
     * @throws InterruptedException
     */
    @Test
    public void windowAssert() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.baidu.com/123","当前网址不是百度");
        Thread.sleep(3000);
        webDriver.quit();
    }

    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }

}
