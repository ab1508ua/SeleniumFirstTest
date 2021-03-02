import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void checkurl() {
        System.setProperty ("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS );

        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(By.xpath(".//button[@data-qa-node='phone-code']")).sendKeys("+380");
        driver.findElement(By.xpath(".//input[@data-qa-node='phone-number']")).sendKeys("501536163");
        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@data-qa-node='numberdebitSource']")).sendKeys("4506503231399019");
        driver.findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']")).sendKeys("10/21");
        driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys("463");
        driver.findElement(By.xpath(".//button[contains(text(),'В кошик')]")).click();
        By details = By.xpath(".//span[@data-qa-node='details']");
        By card = By.xpath(".//td[@data-qa-node='card']");
        By amount = By.xpath(".//span[@data-qa-node='amount']");
        By commission = By.xpath(".//span[@data-qa-node='commission']");
        By total = By.xpath(".//div[@data-qa-node='total']");
        By commissionCurrency = By.xpath(".//small[@data-qa-node='commission-currency']");


        Assert.assertEquals("Поповнення телефону. На номер +380501536163", driver.findElement(details).getText());
        Assert.assertEquals("4506 **** **** 9019", driver.findElement(card).getText());
        Assert.assertEquals("50", driver.findElement(amount).getText());
        Assert.assertEquals("2", driver.findElement(commission).getText());
        Assert.assertEquals("50 UAH", driver.findElement(total).getText());
        Assert.assertEquals(" UAH", driver.findElement(commissionCurrency).getText());


    }

}
