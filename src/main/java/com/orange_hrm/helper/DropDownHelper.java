package com.orange_hrm.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownHelper {

    protected WebDriver driver;
    WebElementActions webElementActions = new WebElementActions();

    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
    }

    public DropDownHelper selectByVisibleText(WebElement element, String value) {

        Select select = new Select(element);
        List<WebElement> optionsList = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        // Проходим по всем опциям и добавляем их текст в список
        for (WebElement option : optionsList) {
            optionTexts.add(option.getText());
        }
        // Выводим все тексты опций
        for (String text : optionTexts) {
            System.out.println("Option: " + text);
        }
        select.selectByVisibleText(value);
        return this;
    }

    public void printoutSelectList(WebElement element, List<WebElement> dropdownItems) {
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        webElementActions.waitElementToBeClickable(element).click(element);
        ArrayList<String> itemList = new ArrayList<>();
        // Добавление всех текстов элементов в ArrayList
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
        // Выводим все тексты опций
        for (String text : itemList) {
            System.out.println("Option: " + text);
        }
    }

    public void printoutSelectList(WebElement element) {
        Select select = new Select(element);
        // Получение списка опций
        List<WebElement> options = select.getOptions();
        // Вывод всех опций
        for (WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }
    }

    public DropDownHelper selectAllOptions(WebElement element) {

        Select select = new Select(element);
        select.getAllSelectedOptions();
        return this;
    }

    public DropDownHelper selectAllCars(WebElement element) {

        Select select = new Select(element);
        select.getAllSelectedOptions();
        return this;
    }

    public DropDownHelper selectOne(WebElement element) {

        Select select = new Select(element);
        select.getOptions();
        return this;
    }


}
