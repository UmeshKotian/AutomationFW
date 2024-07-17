package Support;

import org.openqa.selenium.WebDriver;
import pages.AmazonPage;

public class World {

    final WebDriver driver = new BrowserCreation().getDriver();
    public static AmazonPage amazonPage;

    public void driverClass() {
        try {
            World.amazonPage = new AmazonPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
