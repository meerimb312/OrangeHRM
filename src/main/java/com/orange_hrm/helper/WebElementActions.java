package com.orange_hrm.helper;


import com.orange_hrm.drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.orange_hrm.drivers.DriverManager.getDriver;


public class WebElementActions {

    public Actions actions = new Actions(getDriver()); //для работы с мышкой

    @BeforeClass(alwaysRun = true)
    public void init() {
        actions = new Actions(getDriver());
    }

    @Step("Performing click {1}")
    public WebElementActions click(WebElement element) {
        waitElementToBeClickable(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        highlightElement(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions sendKeysWitEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = arguments[1];", element, txt);
        return this;
    }

    public WebElementActions doubleClick(WebElement element) { //
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) { //
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }

    // метод находит все элементы по указанному xPath, ложит их в лист
    // рандомно выбирает один из элементов
    public WebElement randomElementSelection(String xPath) {
        List<WebElement> list = getDriver().findElements(By.xpath(xPath));
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    // метод находит все элементы по указанному xPath, ложит их в лист
    // рандомно выбирает один или несколько элементов, и кликает на них
    public void clickRandomElements(String xpath) {
        List<WebElement> list = getDriver().findElements(By.xpath(xpath));
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Элементы не найдены");
        }
        Random random = new Random();
        int index1 = random.nextInt(list.size()) + 1; // Добавляем 1, чтобы index1 был как минимум 1
        List<WebElement> randomElements = new ArrayList<>();
        for (int i = 0; i < index1; i++) {
            int index = random.nextInt(list.size());
            randomElements.add(list.get(index));
            list.remove(index); // Удаляем выбранный элемент из списка, чтобы не выбрать его снова
        }
        for (WebElement element : randomElements) {
            jsClick(element);
        }
    }

    // метод находит элемент по указанному xPath, кликая на него раскрывает всплывающий список
    // по указанному xPath ложит весь всплывающий список в лист
    // рандомно выбирает один из элементов
    public String randomElementSelection(String xpathDropdownControl, String xpathDropdownItems) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        // Нахождение контроллера списка и открытие списка
        WebElement dropdownControl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDropdownControl)));
        dropdownControl.click();
        // Явное ожидание появления элементов списка
        List<WebElement> dropdownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathDropdownItems)));
        // Создание списка для хранения текстов элементов
        ArrayList<String> itemList = new ArrayList<>();
        // Добавление всех текстов элементов в ArrayList
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
        Random random = new Random();
        int index = random.nextInt(itemList.size());
        return itemList.get(index);
    }

    public void pause(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement fluentWait(By locator, int timeoutOfSeconds, int polingInseconds) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeoutOfSeconds))
                .pollingEvery(Duration.ofSeconds(polingInseconds))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver1) {
                WebElement element = driver1.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }

        });
        return element;
    }
}