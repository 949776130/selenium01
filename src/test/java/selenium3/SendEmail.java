package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendEmail {
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
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * 关闭浏览器进程
     */
    @AfterMethod
    public void quitBrowser(){
        webDriver.quit();
    }

    @Test
    public void sendEmail() throws InterruptedException {
        //登录邮箱
        SendEmail.login(webDriver,"wo949776130","wo06100155");
//        new WebDriverWait(webDriver, 10).
//                until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")));
        //点击写信按钮
        webDriver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //收件人
        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("wo949776130@163.com");
        //主题
        webDriver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("测试发送");
        //上传附件
        webDriver.findElement(By.xpath(".//*[@class='by0']/input")).sendKeys("F:\\传智播客\\框架\\资料库\\图片扩展\\大广告位图片\\1.jpg");
        //控制权转交给文本输入框
        WebElement iframe = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(iframe);
        //发送的内容
        webDriver.findElement(By.className("nui-scroll")).sendKeys("发送内容");
        //转交页面的控制权
        webDriver.switchTo().defaultContent();
        //发送按钮-----通过定位text()内容来定位元素
        webDriver.findElement(By.xpath(".//*[text()='发送']")).click();
        Thread.sleep(5000);
    }

    /**
     * 登录方法
     * @param webDriver
     * @param email
     * @param password
     */
    public static void login(WebDriver webDriver,String email,String password){
        webDriver.get("https://mail.163.com/");
        webDriver.findElement(By.id("lbNormal")).click();
        WebElement iframe = webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div[3]/div[1]/div[1]/iframe"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }
}
