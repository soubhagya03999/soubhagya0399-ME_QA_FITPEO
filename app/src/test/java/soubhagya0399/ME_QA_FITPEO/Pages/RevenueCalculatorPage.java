package soubhagya0399.ME_QA_FITPEO.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The RevenueCalculatorPage class provides methods to interact with the Revenue Calculator page on the Fitpeo website.
 */
public class RevenueCalculatorPage {
    // Static instance of ChromeDriver
    static ChromeDriver driver;

    // URL of the Revenue Calculator page
    static String url = "https://fitpeo.com/revenue-calculator";

    /**
     * Navigates to the Revenue Calculator page using the provided ChromeDriver instance.
     *
     * @param driver The ChromeDriver instance to be used for navigation.
     */
    public static void navigateToRevenueCalculatorPage(ChromeDriver driver) {
        try {
            // Open the Revenue Calculator page
            driver.get(url);
        } catch (Exception e) {
            // Handle any exceptions that occur during navigation
            e.printStackTrace();
        }
    }

    /**
     * Scrolls the webpage until the Revenue Calculator slider is visible.
     *
     * @param driver The ChromeDriver instance to be used for scrolling.
     */
    public static void ScrollUntilRevenueCalculatorSlider(ChromeDriver driver) {
        try {
            // Use JavaScript to scroll the webpage
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            // Wait for 5 seconds to ensure the scroll completes
            Thread.sleep(5000);
        } catch (Exception e) {
            // Handle any exceptions that occur during scrolling
            e.printStackTrace();
        }
    }

    /**
     * Sets the slider value using Actions to move the slider thumb iteratively.
     *
     * @param driver The WebDriver instance to be used for interaction.
     * @param targetValue The target value to set on the slider.
     */
    public static void setSliderValueUsingActions(WebDriver driver, int targetValue) {
        try {
            // Wait until the slider element is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sliderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=range]")));
            WebElement thumbElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiSlider-thumb")));

            Actions actions = new Actions(driver);
            int stepSize = 5; // Define the step size for moving the slider

            // Get the current slider value
            int currentValue = Integer.parseInt(sliderElement.getAttribute("value"));

            // Move the slider thumb iteratively until the target value is reached
            while (currentValue < targetValue) {
                actions.clickAndHold(thumbElement)
                       .moveByOffset(stepSize, 0)
                       .release()
                       .perform();
                // Update the current value
                currentValue = Integer.parseInt(sliderElement.getAttribute("value"));
                // Exit loop if currentValue is greater than or equal to targetValue
                if (currentValue >= targetValue) {
                    break;
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during slider interaction
            e.printStackTrace();
        }
    }

    /**
     * Updates the specified text field with a new value.
     *
     * @param driver The ChromeDriver instance to be used for interaction.
     * @param num The new value to be set in the text field.
     */
    public static void UpdateTextField(ChromeDriver driver, int num) {
        try {
            // Locate the text field element
            WebElement elem = driver.findElement(By.id(":R57alklff9da:"));
            Actions actions = new Actions(driver);
            // Clear the existing text and enter the new value
            actions.click(elem).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                   .sendKeys(String.valueOf(num));
            actions.build().perform();
        } catch (Exception e) {
            // Handle any exceptions that occur during text field update
            e.printStackTrace();
        }
    }

    /**
     * Validates if the slider value matches the expected value.
     *
     * @param driver The ChromeDriver instance to be used for validation.
     * @param num The expected slider value.
     * @return true if the slider value matches the expected value, false otherwise.
     */
    public static boolean ValidateSliderValue(ChromeDriver driver, int num) {
        try {
            // Wait until the slider element is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sliderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=range]")));
            String actualSliderValue = sliderElement.getAttribute("value");
            // Check if the actual slider value matches the expected value
            return actualSliderValue.equals(String.valueOf(num));
        } catch (Exception e) {
            // Handle any exceptions that occur during validation
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Selects the specified CPT codes from the list of available options.
     *
     * @param driver The ChromeDriver instance to be used for interaction.
     * @param arr An array of CPT codes to be selected.
     */
    public static void SelectCPTCodes(ChromeDriver driver, String[] arr) {
        try {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                String val = arr[i];
                // Locate the list of CPT code elements
                List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'css-1p19z09')]/div/p[contains(text(),'CPT-')]/following::input/parent::span/parent::label/parent::div/p[contains(text(),'CPT-')]"));
                int index = 0;
                // Find the index of the specified CPT code
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getText().equals(val)) {
                        index = j;
                        break;
                    }
                }
                // Locate the input elements and select the specified CPT code
                List<WebElement> list2 = driver.findElements(By.xpath("//div[contains(@class,'css-1p19z09')]/div/p[contains(text(),'CPT-')]/following::input"));
                list2.get(index).click();
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during CPT code selection
            e.printStackTrace();
        }
    }

    /**
     * Validates the total recurring reimbursement displayed on the page.
     *
     * @param driver The ChromeDriver instance to be used for validation.
     * @return The total recurring reimbursement text, or null if an error occurs.
     */
    public static String ValidateTotalRecurringReimbursement(ChromeDriver driver) {
        try {
            // Locate the total recurring reimbursement element
            WebElement elem = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month')]/p[text()]"));
            return elem.getText();
        } catch (Exception e) {
            // Handle any exceptions that occur during validation
            e.printStackTrace();
            return null;
        }
    }
}
