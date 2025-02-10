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
    @Test
    public void logWrongEmail() {
        User user = new User().setEmail("firiallmail.ru").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitLog();


        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent("It snot look like email"), "Error");

    }
    @Test
    public void logWrongPass() {
        User user = new User().setEmail("firiall@mail.ru").setPassword("Tele!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitLog();
       // app.getHelperUser().logOk();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void logEmptyEmail() {
        User user = new User().setEmail("").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitLog();
        //app.getHelperUser().logOk();

        //Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent(" Email is required "), "Error");

    }

    @Test
    public void logEmptyPass() {
        User user = new User().setEmail("firiall@mail.ru").setPassword("");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        //app.getHelperUser().submitLog();
        //app.getHelperUser().logOk();

        //Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent("Password is required"), "Error");


    }

    @Test
    public void ligUnregisteredUser() {
        User user = new User().setEmail("firiall6@mail.ru").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submitLog();
        //app.getHelperUser().logOk();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    //@AfterMethod
   // public void postCondition(){
    //    app.getHelperUser().logOk();
   // }

}
