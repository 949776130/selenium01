package selenium2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
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
     * 点击弹窗的确定按钮
     */
    @Test
    public void alertTest(){
        webDriver.get("http://www.baidu.com");
        webDriver.findElement(By.id("")).click();
        Alert alert = webDriver.switchTo().alert();
        //确定按钮
        alert.accept();
        //取消按钮
        alert.dismiss();
        //在弹窗的输入框输入值
        alert.sendKeys("22344");
        //获取弹窗的文本内容
        String text = alert.getText();
        //如果是ifream框架的话，通过定位id、name、标签名来转交给iframe
        WebElement ifream = webDriver.findElement(By.tagName("ifream"));
        webDriver.switchTo().frame(ifream);
        //点击含链接的百度这两个文字
        webDriver.findElement(By.linkText("baidu")).click();
        //把控制权从ifream框架中转移到外部
        webDriver.switchTo().defaultContent();
        //点击外部含链接的文字
        webDriver.findElement(By.linkText("登录/注册")).click();
    }



    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }
}
