
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentSolution {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cleartrip.com");

        driver.findElement(By.id("Adults")).click();
        //selection from the drop down Adults window, using while loop
        int i = 1;
        while (i < 9) {
            WebElement adults = driver.findElement(By.id("Adults"));
            i++;
            Select value = new Select(adults);
            value.selectByValue("2");
        }

        //another method of selection
        //WebElement adults = driver.findElement(By.id("Adults"));
        //Select s = new Select(adults);
        //s.selectByValue(2);


        //selection from the drop down Children window, using forloop
        driver.findElement(By.id("Childrens")).click();
        for (int k = 0; k < 7; k++) {
            WebElement children = driver.findElement(By.id("Childrens"));
            Select value = new Select(children);
            value.selectByValue("1");
        }

        //select todays date on the calendar
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

        //click more options
        driver.findElement(By.cssSelector(".blue.rArrow")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("IndiGo");

        //click Search Button
        driver.findElement(By.id("SearchBtn")).click();

        //get the error message text
        String errorText = driver.findElement(By.id("homeErrorMessage")).getText();
        System.out.println(errorText);
    }
}
