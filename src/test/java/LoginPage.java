import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "login[username]")
    WebElement txtUsername;
    @FindBy(name = "login[password]")
    WebElement txtPassword;

    @FindBy( id = "send2")
    List<WebElement> btnItems;
    @FindBy(className = "authorization-link")
    List<WebElement> signIn;

    @FindBy(className = "ui-menu-icon")
    List<WebElement> menuItems;
    @FindBy(xpath = "//a[contains(text(),\"Jackets\")]")
    WebElement Item;
    @FindBy(className = "product-item-link")
    List<WebElement> productItem;
    @FindBy(className = "swatch-option")
    List<WebElement> size;
    @FindBy(id = "product-addtocart-button")
    WebElement addCartBtn;
    @FindBy(className = "product-image-photo")
    List<WebElement> productImage;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) throws InterruptedException {
        signIn.get(0).click();
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnItems.get(0).click();
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        menuItems.get(3).click();   //This will click the "Men" option from header
        Thread.sleep(2000);
        Item.click();    //This will click the "Jackets" option from sidebar options
        productItem.get(0).click();  //This will click the first product item "Proteus Fitness Jackshirt" from the list
        Thread.sleep(3000);
        size.get(1).click();  //This will click to select "size"
        size.get(5).click();  //This will click to select "color"
        addCartBtn.click();  // This will click to "Add to Cart" button to add the selected product

    }

}
