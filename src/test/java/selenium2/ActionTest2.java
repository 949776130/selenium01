package selenium2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionTest2 {
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
     * 右键
     */
    @Test
    public void contextClick() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        WebElement buttenBaidu = webDriver.findElement(By.id("su"));
        //创建一个实例化actions对象
        Actions actions = new Actions(webDriver);
        //对百度一下按钮右击:contextClick，执行:perform()
        //actions.contextClick(buttenBaidu).perform();
        //右击空白处
        //actions.contextClick().perform();
        //双击某个元素
        //actions.doubleClick(buttenBaidu).perform();
        //双击空白处
        //actions.doubleClick().perform();
        actions.moveToElement(buttenBaidu).perform();
        Thread.sleep(3000);
    }

    //
    @Test
    public void moveToElement() throws InterruptedException {
        webDriver.get("http://news.baidu.com/");
        WebElement element1 = webDriver.findElement(By.xpath(".//*[@id='header-link-wrapper']/li[3]/a"));
        WebElement element2 = webDriver.findElement(By.xpath(".//*[@id='s_ipt_wr']"));
        //实例化一个actions
        Actions actions = new Actions(webDriver);
        //把一个元素拖动到另一个元素上，释放元素
        actions.clickAndHold(element1)
                .moveToElement(element2)
                .release(element1)
                .perform();
        //鼠标移动到指定元素上
        //actions.moveToElement(element).perform();
        //把元素拖动到(x,y)
        //actions.dragAndDropBy(element,100,200);
        Thread.sleep(5000);
        //String text = webDriver.findElement(By.xpath(".//*[text()='中概股周一迎普跌 趣头条跌逾13%']")).getText();
        //System.out.println(text);
    }

    //点击下拉框选项
    @Test
    public void selectsTest() throws InterruptedException {
        webDriver.get("http://news.baidu.com/z/resource/pc/staticpage/pianhao.html");
        //实例化一个actions
        Actions actions = new Actions(webDriver);
        //定位到下拉框元素
        WebElement element = webDriver.findElement(By.name("ct"));
        //获取下拉框里面的选项
        List<WebElement> elements = webDriver.findElements(By.xpath("html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/div[3]/select/option"));
        actions.keyDown(Keys.CONTROL).click(elements.get(1)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
    }

    /**
     * 保存百度首页图片
     */
    @Test
    public void test() throws Exception {
        webDriver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(10000);
        robot.keyPress(KeyEvent.VK_ENTER);
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
