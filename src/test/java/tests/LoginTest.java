package tests;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void selectSpecialityTest() {
//        selectSpeciality("Phoniatrics (Speech)");
        ElementActions.type(getDriver(), By.xpath("//input[@name = 'q']"), "github");
        ElementActions.click(getDriver(), By.xpath("(//input[@name = 'btnK'])[2]"));

    }

    private void selectSpeciality(String name) {
        ElementActions.click(getDriver(), By.xpath("//div[contains(@class, 'Headerstyle__HideOnMobile-sc-1s6go99-1')]//button[@id = 'selectSpecialityDropdown']"));
        String specialitySelectionXPath= "//div[contains(@class, 'Headerstyle__HideOnMobile-sc-1s6go99-1')]//ul[@data-testid = 'search-bar__dropdown-speciality__paginated-menu__list']//li[text() = '%s']";
        By specialitySelection = By.xpath(String.format(specialitySelectionXPath, name));
        while(getDriver().findElements(specialitySelection).size() == 0) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.xpath("//div[contains(@class, 'Headerstyle__HideOnMobile-sc-1s6go99-1')]//div[@data-testid = 'search-bar__dropdown-speciality__paginated-menu__arrow--next']")), 550 , 0)
                    .click()
                    .build().perform();
        }
        ElementActions.click(getDriver(), specialitySelection);
    }
}
