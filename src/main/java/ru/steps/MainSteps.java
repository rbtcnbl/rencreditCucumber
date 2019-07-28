package ru.steps;

import cucumber.api.java.mk_cyrl.Кога;
import ru.pages.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Кога("выбран пункт меню \"(.*)\"")
    public void selectMenuItem(String itemName){mainPage.selectItem(mainPage.mainMenu, itemName);}

}
