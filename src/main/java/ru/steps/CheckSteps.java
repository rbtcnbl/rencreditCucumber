package ru.steps;

import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pages.CheckPage;
import ru.util.DriverManager;

public class CheckSteps {

    CheckPage checkPage = new CheckPage();
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 60);


    @Тогда("поле  Ставка на 6 месяцев  будет иметь значение  \"(.*)\"")
    public void stepCheckPercent(String percent) throws Exception{
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class, 'js-calc-rate')]"), "6.75%"));
        Assert.assertEquals(percent, checkPage.getTotalPercent());
    }

    @Тогда("поле  Ставка на 9 месяцев будет иметь значение  \"(.*)\"")
    public void stepCheckPer(String percent) throws Exception{
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class, 'js-calc-rate')]"), "6.30%"));
        Assert.assertEquals(percent, checkPage.getTotalPercent());
    }

    @Тогда("к снятию через 6 месяцев -  \"(.*)\"")
    public void stepCheckResult(String result) throws Exception{
        Assert.assertEquals(result, checkPage.getTotalResult());
    }

    @Тогда("пополнение за 6 месяцев -  \"(.*)\"")
    public void stepCheckReplenish(String replenish) throws Exception{
        Assert.assertEquals(replenish, checkPage.getTotalReplenish());
    }

    @Тогда("пополнение за 9 месяцев -  \"(.*)\"")
    public void stepCheckRep(String replenish) throws Exception{
        Assert.assertEquals(replenish, checkPage.getTotalReplenish());
    }

    @Тогда("начислено -  \"(.*)\"")
    public void stepCheckEarned(String earned) throws Exception{
        Assert.assertEquals(earned, checkPage.getTotalEarned());
    }


//    @Тогда("к снятию через 9 месяцев -  \"(.*)\"")
//    public void stepCheckRes(String result) throws Exception{
//        Assert.assertEquals(result, checkPage.getTotalResult());
//    }



}
