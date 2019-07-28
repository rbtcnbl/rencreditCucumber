package ru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.annotation.FieldName;

import java.util.List;

public class ContributionsPage extends BaseObjectPage {

    @FieldName(name = "Валюта")
    @FindBy(xpath = "//span[@class='calculator__currency-field-btn']")
    public List<WebElement> currencyBtn;


    @FieldName(name = "Сумма вклада")
    @FindBy(xpath = "//input[@name='amount']")
    public WebElement amountField;


    @FieldName(name = "На срок")
    //@FindBy(xpath = "//div[contains(@class, 'range-scale range-scale_item_6')]/div[contains(@class, 'range-scale__item range-scale__item_1')]")
    //@FindBy(xpath = "select")
    @FindBy(xpath = "//div[@class='jq-selectbox__select']")
    public WebElement rangeField;


    @FieldName(name = "Ежемесячное пополнение")
    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement replenishField;

    @FieldName(name = "Ежемесячная капитализация")
    @FindBy(xpath = "//input[contains(@name, 'capitalization')]//ancestor::div[1]")
    public WebElement checkCapitalization;

    @FieldName(name = "Частичное снятие")
    @FindBy(xpath = "//input[contains(@name, 'partial_out')]//ancestor::div[1]")
    public WebElement checkPatialOut;

    @Override
    public WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.ContributionsPage");
    }

    public void selectTerm(String term) {
        Select timeSelect = new Select(rangeField);
        timeSelect.selectByValue(term);
    }
}
