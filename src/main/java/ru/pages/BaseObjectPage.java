package ru.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.annotation.FieldName;
import ru.util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class BaseObjectPage {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);


    public BaseObjectPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement getField(String name, String className) throws ClassNotFoundException {
        Class classExample = Class.forName(className);
        List<Field> fields = Arrays.asList(classExample.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equals(name)) {
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    abstract WebElement getField(String name) throws ClassNotFoundException;

    public void fillField(String name, String value) throws ClassNotFoundException {
        WebElement element = getField(name);
        element.clear();
        element.sendKeys(value);
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void click(String name) throws ClassNotFoundException {
        WebElement element = getField(name);
        click(element);
    }

    public void selectInput(WebElement element, String value){
        //element.click();
        element.findElement(By.xpath("//div[contains(@class, 'range-scale range-scale_item_6')]/div[text()= '" + value + "']")).click();
    }

    public void selectItem(List<WebElement> items, String name) {
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(name)) {
                item.click();
                return;
            }
        }

        Assert.fail("Не найден элемент коллекции с наименованием" + name);
    }





}


