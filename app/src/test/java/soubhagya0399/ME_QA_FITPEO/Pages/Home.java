package soubhagya0399.ME_QA_FITPEO.Pages;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * The Home class provides methods to navigate to the homepage of the Fitpeo website.
 */
public class Home {
    // Static instance of ChromeDriver
    static ChromeDriver driver;

    // URL of the Fitpeo homepage
    static String url = "https://www.fitpeo.com/";

    /**
     * Navigates to the Fitpeo homepage using the provided ChromeDriver instance.
     *
     * @param driver The ChromeDriver instance to be used for navigation.
     */
    public static void navigateToHomePage(ChromeDriver driver) {
        try {
            // Open the Fitpeo homepage
            driver.get(url);
        } catch (Exception e) {
            // Handle any exceptions that occur during navigation
            e.printStackTrace();
        }
    }
}
