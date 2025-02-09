package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        //if SingOut present ===>logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logOut();

    }
    @Test
    public void loginSuccess1()
    {
        User user = new User().setEmail("firiall@mail.ru").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
       // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitLog();
        app.getHelperUser().logOk();
        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");


    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().logOk();
    }

}
