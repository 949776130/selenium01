package selenium2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
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
     * 点击百度首页新闻按钮，校验网址是否正确
     */
    @Test
    public void clickElement(){
        webDriver.get("http://www.baidu.com");
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        element.click();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://news.baidu.com/");
    }

    /**
     * 在百度搜索框输入关键字selenium，清空再操作，校验跳转后的页面标题
     */
    @Test
    public void assertTitle() throws InterruptedException {
        //访问百度页面
        webDriver.get("http://www.baidu.com");
        //获取输入框并输入关键字selenium
        WebElement inputKey = webDriver.findElement(By.id("kw"));
        inputKey.sendKeys("selenium");
        Thread.sleep(3000);
        inputKey.clear();
        Thread.sleep(3000);
        inputKey.sendKeys("selenium");
        //点击百度一下按钮
        WebElement buttonBaidu = webDriver.findElement(By.id("su"));
        buttonBaidu.click();
        Thread.sleep(1000);
        //校验页面标题是否正确
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 百度首页，用getText校验获取的文本
     */
    @Test
    public void getText(){
        webDriver.get("http://www.baidu.com");
        String trnews = webDriver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(trnews,"新闻");
    }

    /**
     * 用getAttribute获取属性值
     */
    @Test
    public void assertValue(){
        webDriver.get("http://www.baidu.com");
        String attribute = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }

    /**
     * 判断未激活
     */
    @Test
    public void isEnable(){
        webDriver.get("http://tlias-stu.boxuegu.com/#/login");
        boolean enabled = webDriver.findElement(By.xpath(".//*[@id='app']/div/div[3]/div/div/div[2]/form/button")).isEnabled();
        Assert.assertTrue(enabled);
    }

    /**
     * 判断单选框是否被选中，通过xpath来定位
     */
    @Test
    public void isSelected() throws InterruptedException {
        webDriver.get("http://tlias-stu.boxuegu.com/#/login");
        //拿到选中的元素，点击
        WebElement b = webDriver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div[2]/form/div[4]/label/span[1]/span"));
        //b.click();
        //Thread.sleep(2000);
        //判断是否点击上
        boolean selected = b.isSelected();
        System.out.println(selected);
        //断言是否为true
        Assert.assertTrue(selected);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
        webDriver.get("http://www.baidu.com");
        //调用getScreenshotAs方法截图当前窗口，并输出成一个file文件
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            //将file文件输出为png格式的图片
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }
}
