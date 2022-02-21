package Pages.home;

import Components.LoginComponent;
import Pages.ReusableViewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ReusableViewElements {

    private String titleSelector = ".ui-panel-title";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginComponent getLoginComponent(){return new LoginComponent(getDriver());}

    public String getHomePageTitle(){
        return find(By.cssSelector(titleSelector)).getText();
    }

}
