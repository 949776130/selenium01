package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
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
     * 下拉框选择：
     *      1.通过索引
     *      2.通过value值
     *      3.通过文本值
     */
    @Test
    public void selectTest(){
        webDriver.get("http://www.baidu.com");
        //先获取到哪个元素
        WebElement element = webDriver.findElement(By.name("aa"));
        //实例化一个select对象，把要操作的下拉框元素作为参数
        Select select = new Select(element);
        //用select对象，通过index值来
        select.selectByIndex(2);
        //用select对象，通过value来选择
        select.selectByValue("iphone");
        //用select对象，通过标签中的文本值
        select.selectByVisibleText("vivo");
    }

    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }
}
