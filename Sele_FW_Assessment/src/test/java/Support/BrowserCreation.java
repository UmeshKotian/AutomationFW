package Support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class BrowserCreation {

    public static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BrowserCreation.class);
    public static Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        log.info("Currently executing Scenario -->" + scenario.getName());
        BrowserCreation.scenario = scenario;

        log.info("os.name  --> " + System.getProperty("os.name"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        new World().driverClass();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
