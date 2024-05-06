package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LoginPage;
import utilities.XUtilis;

import java.io.IOException;

public class LoginTCs_DDT extends BeforeEachClass {


    @Test(dataProvider="loginData")
    public void loginDDT(String username,String password) {
        LoginPage login = new LoginPage(driver);
        login.setUsername(username);
        logger.info("Username entered");

        login.setpassword(password);
        logger.info("Password entered");

        login.clickLogin();
        logger.info("Login successfully");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/v3/manager/Managerhomepage.php");
    }
    @DataProvider(name="loginData")
    String [][]  getData() throws IOException {
        String path=System.getProperty("user.dir")+"/src/test/java/testData/Book1.xlsx";
        int rownum= XUtilis.getRowCount(path, "Sheet1");
        int colcount=XUtilis.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XUtilis.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }
    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);//create a 8 chars random String
        return generatedString ;
    }
    }

