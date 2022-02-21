package Utils.constance;

import org.openqa.selenium.By;

public enum ContextMRMenu {
    RESULTING_CONTRACT(By.xpath("//div[@id='id_menu_1_valueCell8']/div")),
    SUMMARY(By.xpath("//div[@id='id_menu_1_valueCell0']/div"));;

    private final By contextMenuByName;

    ContextMRMenu(By contextMenuByName) {
        this.contextMenuByName = contextMenuByName;
    }

    public By getContextMenuByName() {
        return contextMenuByName;
    }
}
