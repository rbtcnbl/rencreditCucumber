package ru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.annotation.FieldName;

import java.util.List;

public class MainPage  extends  BaseObjectPage{

    @FieldName(name = "Главное меню")
    @FindBy(xpath = "//div[@class='service__title']")
    public List<WebElement> mainMenu;


    @Override
    WebElement getField(String name) throws ClassNotFoundException {
        return getField(name, "ru.pages.MainPage");
    }
}
