package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class PhantomJS {
    //用phantomjs可以代替webdriver执行，可以不用启动浏览器
    @Test
    public void phantomJS() throws InterruptedException {
        //设置驱动器的路径
        System.setProperty("phantomjs.binary.path","F:\\IdeaProjects\\Selenium01\\drivers\\phantomjs.exe");
        //创建phantomJS驱动器
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("毛泽东");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
