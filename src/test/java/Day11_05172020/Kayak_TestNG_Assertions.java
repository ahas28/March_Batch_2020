package Day11_05172020;

import Reusable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Kayak_TestNG_Assertions {

    //declare the webdriver outside of all method to be reusable
    WebDriver driver;

    @BeforeSuite
    public void defineDriver (){
        driver = Reusable_Library.setDriver();
    }//end of before suite

    @Test
        public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https//www.kayak.com");
        Thread.sleep(2000);
        //verify the title using hard assertion
        //Assert.assertEquals(driver.getTitle),"Search Hotels, Cars");
        //using soft assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(),"Search Hotels, Cars");
        //click airport or city
        Reusable_Library.click(driver,"//*[@data-placeholder='Enter an airport or city']","Search Filed");
        //enter the airport
        Reusable_Library.userKeys(driver,"//*[@name='pickup']","JFK","Search Field");
        Thread.sleep(3000);
        //pass assertAll that way it doesnt't skip all your test steps
        sAssert.assertAll();
    }//end of test method

    @AfterSuite
    public void closeSesion(){
        driver.quit();
    }//end of after suite
}//end of java class
