package selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void testChrome() throws InterruptedException, MalformedURLException {
        //指定使用的浏览器
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        //指定node的地址，分给到node上。若写明是hub地址，则由hub自动分发到node上
        //WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.102:5555/wd/hub",chrome));
        // WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.102:5555/wd/hub",chrome));
        //driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        //driver.quit();
    }

    //创建数据驱动
    /*@DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object][][]{
            {"firefox","http://192.168.1.102:8888/wd/hub"},{"chrome","http://192.168.1.102:5555/wd/hub"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser,String url) throws InterruptedException {
        DesiredCapabilities dc = null;
        if(browser.contentEquals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.contentEquals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        //把脚本交给hub，由hub自动分发给node执行，并运行不同的浏览器驱动
        RemoteWebDriver driver = new RemoteWebDriver(new URL(url, dc));
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }*/
}
