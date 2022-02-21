package Components;

import Pages.ReusableViewElements;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginComponent extends ReusableViewElements {

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        element(By.id("login:user")).sendKeys(username);
    }

    public void setUsernameMilesRia(String username) {
        waitABit(2000);
        element(By.name("username")).sendKeys(username);
    }

    public void setPassword(String pwd) {
        element(By.id("login:password")).sendKeys(pwd);
    }

    public void setPasswordMilesRia(String pwd) {
        element(By.name("password")).sendKeys(pwd);
    }

    public void submitLoginCredential() {
        element(By.id("login:loginButton")).click();
        waitABit(2000);
    }

    public void submitLoginCredentialMilesRia() {
        element(By.id("isc_1I")).click();
        waitABit(1000);
    }
}
