package Pages.customer;

import Components.customer.IndividualComponent;
import Components.customer.OrganizationComponent;
import Components.customer.SoleTraderComponent;
import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerPage extends ReusableViewElements {

    private final By tabId = By.id("quote:prospectdetail:prospectView:main:legalentitygroup");
    private final By buttonClass = By.className("ui-state-default");

    public IndividualComponent getIndividualComponent(){return new IndividualComponent (getDriver());}
    public OrganizationComponent getOrganizationComponent(){return new OrganizationComponent(getDriver());}
    public SoleTraderComponent getSoleTraderComponent(){return new SoleTraderComponent(getDriver());}

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void chooseTab(int index){
        WebElementFacade elt = element(tabId);
        List<WebElementFacade> elts = elt.thenFindAll(buttonClass);
        System.out.println(elts.size());
        elts.get(index).click();
        waitABit(3000);
    }
}
