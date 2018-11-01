package selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
    //数据源
    @DataProvider(name = "data1")
    public Object[][] privder(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"}
        };
    }

    //引用测试数据源
    @Test(dataProvider = "data1")
    public void test1(String user,String pwd){
        System.out.println(user+pwd);
    }

}
