package com.mkw.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium1 {
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
    //假设方法运行失败，此方法用来关闭webdriver资源
    @AfterMethod
    public void closedBrowser(){
        webDriver.quit();
    }

    /**
     * 网站登录
     */
    @Test
    public void loginTest() throws InterruptedException {
        webDriver.get("https://www.imooc.com/user/newlogin");
        /*webDriver.get("https://www.imooc.com/");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(".//*[@id='nav']/ul/li[3]/a")).click();
        Thread.sleep(5000);*/
        webDriver.findElement(By.name("email")).sendKeys("13711608651");
        webDriver.findElement(By.name("password")).sendKeys("06100155");
        Thread.sleep(5000);
        webDriver.findElement(By.className("moco-btn moco-btn-red moco-btn-lg btn-full xa-login")).click();
        Thread.sleep(10000);
    }

}
