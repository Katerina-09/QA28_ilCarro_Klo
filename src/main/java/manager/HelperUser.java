package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLogForm(){
        click(By.xpath("//a[contains(@href, '/login')]"));

    }
    public void fillLogForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"), password);

    }
    public void fillLogForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void submit(){
        click(By.cssSelector("button[type = 'submit']"));

    }
    public void logOk(){
        click(By.xpath("//button[contains(text(), 'Ok')]"));
    }
    public boolean isLogged(){
        return isElementPresent(By.cssSelector("a[href='/logout?url=%2Fsearch']"));
    }
    public void logOut(){
        click(By.cssSelector("a[href='/logout?url=%2Fsearch']"));

    }
    public void logout() {
        click(By.xpath("//*[text()= ' Logout ']"));}



        public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isErrorMassagePresent(String mess) {
        List<WebElement> errorElements = wd.findElements(By.xpath("//div[@class='error']"));
        return !errorElements.isEmpty();
    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    //***********************************

    public void openRegForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        //click(By.cssSelector("label[for='terms-of-use']"));

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }
}
