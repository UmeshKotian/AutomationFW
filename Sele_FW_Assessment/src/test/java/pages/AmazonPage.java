package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class AmazonPage {

    private static final Logger log = LoggerFactory.getLogger(AmazonPage.class);
    private final WebDriver driver;
    String productPriceInString;
    String cartPagePriceValue;
    String cartPageSubTotalValue;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchIcon;

    @FindBy(xpath = "(//div[@data-component-type='s-search-result'])[1]//img")
    private WebElement firstSearchResult;

    @FindBy(xpath = "(//div[@data-component-type='s-search-result'])[2]//img")
    private WebElement secondSearchResult;

    @FindBy(xpath = "(//div[2]//input[@id='add-to-cart-button'])[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//div[2]//input[@id='add-to-cart-button'])[2]")
    private WebElement addToCartButton1;

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private WebElement cartButton;

    @FindBy(css = "div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-price-whole']")
    private WebElement productPagePrice;

    @FindBy(xpath = "(//span[@class='a-price-whole'])[2]")
    private WebElement productPagePrice1;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    private WebElement cartPagePrice;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    private WebElement cartPageSubTotal;

    public void amazonHomePage() {
        driver.get("https://www.amazon.in/");
    }

    public void enterItemInSearchField(String itemName) {
        searchField.sendKeys(itemName);
    }

    public void clickSearch() {
        searchIcon.click();
    }

    public void clickFirstSearchResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchResult));
        firstSearchResult.click();
    }

    public void clickSecondSearchResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(secondSearchResult));
        secondSearchResult.click();
    }

    public void clickAddToCartButton() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCartButton);
    }

    public void clickAddToCartButton1() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton1));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addToCartButton1);
    }

    public void clickOnCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }

    public void getProductPagePrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(productPagePrice));
        productPriceInString = productPagePrice.getText();
        System.out.println("productPriceInString " + productPriceInString);
    }

    public void getProductPagePrice1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(productPagePrice1));
        productPriceInString = productPagePrice1.getText();
        System.out.println("productPriceInString " + productPriceInString);
    }

    public void getCartPagePrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cartPagePrice));
        cartPagePriceValue = cartPagePrice.getText();
        System.out.println("productPriceInString " + cartPagePriceValue);
    }

    public void getCartPageSubTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cartPageSubTotal));
        cartPageSubTotalValue = cartPageSubTotal.getText();
        System.out.println("productPriceInString " + cartPageSubTotalValue);
    }

    public void verifyProductPageValueWithCartPrice() {
        Assert.assertEquals(cartPagePriceValue.trim(), productPriceInString + ".00");
    }

    public void verifyProductPageValueWithCartSubTotal() {
        Assert.assertEquals(cartPagePriceValue.trim(), productPriceInString + ".00");
    }
}
