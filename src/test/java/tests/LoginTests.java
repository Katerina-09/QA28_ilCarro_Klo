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
        app.getHelperUser().submit();
       // app.getHelperUser().pause(5000);
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
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);


        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent("It snot look like email"), "Error");
        //Assert.assertEquals(app.getHelperUser().getErrorText(), "It snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }
    @Test
    public void logWrongPass() {
        User user = new User().setEmail("firiall@mail.ru").setPassword("Tele!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);
       // app.getHelperUser().logOk();

        Assert.assertFalse(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getErrorText(), "\"Login or Password incorrect\"");
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void logEmptyEmail() {
        User user = new User().setEmail("").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);
        //app.getHelperUser().logOk();

        //Assert.assertFalse(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required"");
        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent("Email is required"), "Error");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void logEmptyPass() {
        User user = new User().setEmail("firiall@mail.ru").setPassword("");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);
        //app.getHelperUser().logOk();

        //Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMassagePresent(" Password is required "), "Error");
        //Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required"");
       // Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());


    }

    @Test
    public void logUnregisteredUser() {
        User user = new User().setEmail("firiall6@mail.ru").setPassword("Tele2user1!");
        //user.setEmail("firiall@mail.ru");
        // user.setPassword("Tele2user1!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);
        //app.getHelperUser().logOk();

        Assert.assertFalse(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getErrorText(), "\"Login or Password incorrect\"");
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
   }

}
