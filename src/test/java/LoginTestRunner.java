import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test(priority = 1)
    public void doLogin() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.doLogin("hmniaz2959@gmail.com", "Test123456");
    }
    @Test(priority = 2)
    public void addToCart() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.addToCart();
    }
}
