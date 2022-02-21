package Pages.milesRiaPages;

import Components.quotesMR.CreditScoreMRComponent;
import Components.quotesMR.ResultingContractMRComponent;
import Pages.ReusableViewElements;
import Utils.CurrentProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class QuotesPage extends ReusableViewElements {
    public QuotesPage(WebDriver driver) {
        super(driver);
    }

    private final By submenu_down = By.xpath("//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Menu/submenu_down.png')]");
    private final String NEXT_BUTTONS = "//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/24/status_next.png?')]";
    private final String Action = "//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/16/action.png?')]";
    private final String OK = "//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/16/ok.png?')]";
    private final By stipulation= By.id("id_menu_2_valueCell3");
    private final String REFRESH = "//img[contains(@src,'" + currentProperties.getCurrentCountryIP() + "milesria/resource/skins/MRI/images/Sofico/16/refresh.png?')]";


    public CreditScoreMRComponent getCreditScoreMRComponent() {
        return new CreditScoreMRComponent(getDriver());
    }

    public ResultingContractMRComponent getResultingContractMRComponent() {
        return new ResultingContractMRComponent(getDriver());
    }

    public void clickOnCopy() {
        waitABit(2500);

        if (currentProperties.getCurrentCountry().equalsIgnoreCase("italy")) {
            findAll(submenu_down).get(1).click();
        } else {
            findAll(submenu_down).get(1).click();
        }

//        waitABit(1000);
//        findAll(OK).get(0).click();
//        waitABit(1000);
    }

    public void selectNewRequest() {
        waitABit(1500);
        if (currentProperties.getCurrentCountry().equalsIgnoreCase("italy")) {
            findAll(By.xpath("//tbody/tr[4]/td[2]/div")).get(3).click();
        } else {
            element(By.xpath("//*[contains(text(),'New Request')]")).click();
        }
    }

    private void clickOnValidate() {
        waitABit(4000);
        List<WebElementFacade> getAllNextButton = findAll(NEXT_BUTTONS);
//        if(currentProperties.getCurrentCountry().equalsIgnoreCase("italy")){
//            getAllNextButton.get(1).click();
//        }
        getAllNextButton.get(0).click();
    }

    private void clickOnApprove() {
        waitABit(4000);
        List<WebElementFacade> getAllNextButton = findAll(NEXT_BUTTONS);
        getAllNextButton.get(0).click();
        waitABit(2000);
    }

    public void selectsCreditApplication() {
        waitABit(2000);
        List<WebElementFacade> silkClickableLink = findAll(By.className("silkClickableLink"));
        silkClickableLink.get(0).click();
        waitABit(3000);
    }

    public void clickOnStipulation() {
        element(stipulation).click();
        waitABit(3000);
    }

    public void clickOnRefresh() {
        waitABit(1500);
        findAll(REFRESH).get(5).click();
        waitABit(2000);
    }
}
