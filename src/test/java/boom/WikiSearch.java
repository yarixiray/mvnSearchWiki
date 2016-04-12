package boom;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class WikiSearch {
    private static FirefoxDriver driver;
    WebElement element;
    By searchBox = By.id ("searchInput");
    String searchQuery = "Watermelon";
    String searchQueryM = "Melon";
    String searchQueryC = "Cucumber";
    By submitSearch = By.cssSelector(".search-container button");

    @Before
    public void openBrowser() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testSearchW(){
        driver.findElement(searchBox).sendKeys(searchQuery);
        driver.findElement(submitSearch).click();
        String search = driver.getPageSource();
        boolean searchResults = search.contains(searchQuery);
        Assert.assertTrue(searchResults);
        }

    @Test
    public void testSearchM(){
        driver.findElement(searchBox).sendKeys(searchQueryM);
        driver.findElement(submitSearch).click();
        String search = driver.getPageSource();
        boolean searchResults = search.contains(searchQueryM);
        Assert.assertTrue(searchResults);
        }

    @Test
    public void testSearchC(){
        driver.findElement(searchBox).sendKeys(searchQueryC);
        driver.findElement(submitSearch).click();
        String search = driver.getPageSource();
        boolean searchResults = search.contains(searchQueryC);
        Assert.assertTrue(searchResults);
    }
}



