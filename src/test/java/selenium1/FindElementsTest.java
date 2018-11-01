package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    /**
     * 创建driver对象
     */
    @BeforeMethod
    public void beforeMethod(){
        //设置webdriver的路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //创建一个chromedriver对象
        driver = new FirefoxDriver();
    }

    @Test
    public void findById() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw"));
        Thread.sleep(3000);
    }

    @Test
    public void findByclassName() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.className("mnav"));
        Thread.sleep(3000);
    }
    @Test
    public void findByName() throws InterruptedException {
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("tj_trmap"));
        Thread.sleep(3000);
    }

    /**
     * 通过linkTest获取一排的元素，并遍历出来
     * @throws InterruptedException
     */
    @Test
    public void findByLinkText() {
        driver.get("http://www.baidu.com");
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='u1']"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
        }
    }

    /**
     * 关闭浏览器进程
     */
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
