package testCases;

import org.testng.annotations.Test;
import Pages.LoginPage;
import utilities.ReadConfig;

public class LoginTCs extends BeforeEachClass{
    ReadConfig readconfig=new ReadConfig();

    public String username= readconfig.getUsername();
    public String password= readconfig.getPassword();
    @Test
    public void loginTest()  {


        logger.info("URL is opend");

        LoginPage login = new LoginPage(driver);
        login.setUsername(username);
        logger.info("Username entered");

        login.setpassword(password);
        logger.info("Password entered");

        login.clickLogin();
        logger.info("Login successfully");
    }
}
