package Components.sale;

import Pages.ReusableViewElements;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class OptionsComponent extends ReusableViewElements {

    //TODO refactor all
    private final By COLOR_LABEL = By.id("quote:ddcolour_label");
    private final By UPHOLSTERY_LABEl = By.id("quote:ddupholstry_label");
    private final By UPHOLSTERY_PANEL = By.id("quote:ddupholstry_panel");
    private final By METALLIC_OR_PEARL_PAINT = By.id("option_6051828");
    private final By SUPER_WHITE_GLOSS_PAINT = By.id("option_6053557");
    private final By DD_COLOR_PANEL = By.id("quote:ddcolour_panel");
    private final By ACCESSORIES_BODY_ELEMENT = By.id("quote:tacc:tbody_element");
    private final By OPTION_PACK_BODY_ELEMENT = By.id("quote:tpack:tbody_element");
    private final By OPTION_BODY_ELEMENT = By.id("quote:topt:tbody_element");

    public OptionsComponent(WebDriver driver) {
        super(driver);
    }

    public void setCarColorByText(String colorName){
        waitABit(2000);
        waitUntilPageCompletelyRender();
        waitABit(2000);  element(COLOR_LABEL).click();
        waitABit(500);
        List<WebElementFacade> anchors = element(DD_COLOR_PANEL).thenFindAll(By.tagName("tr"))
                .stream()
                .filter(c -> c.find(By.tagName("td")).getText().equalsIgnoreCase(colorName))
                .collect(Collectors.toList());
        assertFalse("The color name: "+colorName+" is unknown", anchors.size()!=1);
        scrollToPosition(0,500);
        waitABit(950);
        anchors.get(0).click();
        waitABit(500);
    }

    public void setCarUpholsteryByText(String upholstery) {
        waitABit(2000);
        waitUntilPageCompletelyRender();
        Actions act = new Actions(getDriver());
        act.moveToElement(element(UPHOLSTERY_LABEl));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(UPHOLSTERY_LABEl));
        element(UPHOLSTERY_LABEl).click();
        waitABit(500);
        List<WebElementFacade> anchors = element(UPHOLSTERY_PANEL).thenFindAll(By.tagName("tr"))
                .stream()
                .filter(c -> c.find(By.tagName("td")).getText().equalsIgnoreCase(upholstery))
                .collect(Collectors.toList());
        assertFalse("The upholstery name: "+upholstery+" is unknown", anchors.size()!=1);
        anchors.get(0).click();
    }

    public void setOptionByText(String option){
        waitABit(3000);
        //waitUntilPageCompletelyRender();
        List<WebElement> rows = element(OPTION_BODY_ELEMENT).findElements(By.tagName("tr"));
        for(int i=0; i<rows.size(); i++) {
            List<WebElement> opts = rows.get(i).findElements(By.className("optionNameColumn"));
            for(int j = 0; j < opts.size(); j++) {
                //System.out.println(opts.get(j).getText());
                if(opts.get(j).getText().equalsIgnoreCase(option)){
                    waitABit(1000);
                    rows.get(i).findElement(By.className("optchk")).click();
          //          waitUntilPageCompletelyRender();
                    waitABit(1000);
                    return;
                }
            }
            /*WebElement optionName = rows.get(i).findElement(By.className("optionNameColumn"));
            if(optionName.findElement(By.className("optdescription")).getText().equalsIgnoreCase(option)) {
                rows.get(i).findElement(By.className("optchk")).click();
                System.out.println("test ok");
                waitABit(2000);
            }else {
                assertFalse("Option: " +option +"is unknow", false);
            }*/
        }

    }
    public void setOption(String option) {
        waitABit(3000);
        //waitUntilPageCompletelyRender();
        switch (option.toLowerCase()){
            case "metallic or pearl paint": element(METALLIC_OR_PEARL_PAINT).click();
                break;
            case "super white gloss paint": element(SUPER_WHITE_GLOSS_PAINT).click();
                break;
            default:
                fail(" The option selector for: " + option + " is unknown");
        }
        waitABit(1000);
    }

    public void selectOptionPackByText(String optionPack) {
        waitABit(3000);
        waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = element(OPTION_PACK_BODY_ELEMENT).thenFindAll(By.className("row"))
                .stream()
                .filter(c -> c.find(By.className("optionNameColumn")).getText().equalsIgnoreCase(optionPack))
                .collect(Collectors.toList());
        assertFalse("The optionPack: "+optionPack+" is unknown", anchors.size()!=1);
        if(!currentProperties.getCurrentCountry().equalsIgnoreCase("france")){
            scrollToPosition(0,500);
        }
        waitABit(750);
        WebElement optchk = anchors.get(0).findElement(By.className("optchk"));
        WebElement opt = optchk.findElement(By.tagName("div"));

        Actions act = new Actions(getDriver());
        act.moveToElement(opt).click().build().perform();
        waitABit(500);
    }

    public void setAccessoriesByText(String accessory){
        //waitABit(3000);
        waitUntilPageCompletelyRender();
        List<WebElementFacade> anchors = element(ACCESSORIES_BODY_ELEMENT).thenFindAll(By.tagName("tr"))
                .stream()
                .filter(c -> c.find(By.className("optdescription")).getText().equalsIgnoreCase(accessory))
                .collect(Collectors.toList());
        anchors.get(0).findElement(By.className("optchk")).click();
        waitABit(1000);
    }

    public void selectsOptionFromPopUp() {
        waitABit(2000);
        element(By.cssSelector(".validateOptionActions")).click();
    }

    public void selectOptionInWarningPanel (String option) {
        //waitABit(3000);
        waitUntilPageCompletelyRender();
        WebElement warningPanel = element(By.id("j_idt106"));
        WebElement content = warningPanel.findElement(By.id("j_idt106_content"));
        WebElement opt = content.findElement(By.className("validateOptionActions"));
        if(opt.getText().contains(option)) {
            opt.click();

        }
    }
}
