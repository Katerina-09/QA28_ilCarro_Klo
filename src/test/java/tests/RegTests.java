package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logOut();
    }

    @Test
    public void regSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);


        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(z);

        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + i + "@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openRegForm();
        app.getHelperUser().fillRegForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().pause(5000);

        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");


    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }





}
