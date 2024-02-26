import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test(priority = 1)
    //This method will allow user to login to the website
    public void doLogin() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.doLogin("hmniaz2959@gmail.com", "Test123456");
    }
    @Test(priority = 2)
    //This method will add a product to the cart and verify if the product is successfully added
    public void addToCart() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.addToCart();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.className("counter-number"));
        int count = Integer.parseInt(element.getAttribute("innerText")) ;
        System.out.println(count);
        String txtActual = driver.findElement(By.xpath("//div[contains(text(),\"Jackshirt\")]")).getText();
        String txtExpected = "You added Proteus Fitness Jackshirt";
        Assert.assertTrue(txtActual.contains(txtExpected)); //  This line asserts the text after a product is successfully added to the cart
        Assert.assertTrue((count>=1)?true:false);   //This line checks if the number on the cart logo changes after adding a product to the cart

    }
}
