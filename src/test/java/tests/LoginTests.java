package tests;

import org.testng.Assert;
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
    public void loginSuccess(){

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm("firiall@mail.ru","Tele2user1!");
        app.getHelperUser().submitLog();
        app.getHelperUser().logOk();
        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }

}
