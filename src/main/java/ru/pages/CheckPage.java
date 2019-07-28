package ru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.annotation.FieldName;

public class CheckPage extends BaseObjectPage {


    @FieldName(name = "Ставка")
    @FindBy(xpath = "//span[@class='js-calc-rate']")
    public WebElement rateField;

    @FieldName(name = "Начислено %")
    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement earnedField;

    @FieldName(name = "Сумма пополнения")
    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement replenishField;

    @FieldName(name = "Сумма к снятию")
    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement resultField;

    public String getTotalPercent() {
        return rateField.getText().replaceAll(" \u0025", "");
    }

    public String getTotalResult() {
        return resultField.getText();
    }

    public String getTotalReplenish() {
        return replenishField.getText();
    }

    public String getTotalEarned() {
        return earnedField.getText();
    }

    @Override
    WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.CheckPage");
    }
}
