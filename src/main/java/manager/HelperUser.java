package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void submitLog(){
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
}
