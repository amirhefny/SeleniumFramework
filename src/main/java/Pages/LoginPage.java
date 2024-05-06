package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends MethodsHandle{
    private By usernameField = By.name("uid");
    private By passwordField = By.name("password");
    private By loginBtn =By.name("btnLogin");
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUsername(String username) {
        fill(driver,usernameField,username);
    }
    public void setpassword(String password) {
        fill(driver,passwordField,password);
    }
    public void clickLogin() {
        click(driver,loginBtn);
    }
}
