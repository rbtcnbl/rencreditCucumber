package ru.steps;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;
import ru.pages.ContributionsPage;


public class ContributionsSteps {
    ContributionsPage contributionsPage = new ContributionsPage();



    @Когда("выбрана валюта \"(.*)\"")
    public void selectCurrency(String name) {
        contributionsPage.selectItem(contributionsPage.currencyBtn, name);
    }

    @Когда("поле \"(.*)\" заполняется значением суммы \"(.*)\"")
    public void inputSumAmount(String name, String sum) throws Exception {
        contributionsPage.amountField.click();
        contributionsPage.fillField(name, sum);
    }

    @Когда("выпадающий список \"(.*)\" заполняется значением \"(.*)\"")
    public void selectRange(String field, String range) throws ClassNotFoundException {
        WebElement element = contributionsPage.getField(field);
        contributionsPage.selectInput(element, range);
    }


    @Когда("поле \"(.*)\" заполняется значением \"(.*)\"")
    public void inputSumReplenish(String name, String sum) throws Exception {
        contributionsPage.fillField(name, sum);
    }

    @Когда("выполнено нажатие на \"(.*)\"")
    public void checkBox(String name) throws ClassNotFoundException {
        contributionsPage.click(name);
    }



}
