package com.example.pgbonus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Testing {
    private WebDriver driver;
    public String QRFinexText;
    String qrFinexArray = "";
    public String token = "3acf9af04242c0822c7f3dc9061cfe1bd24664b22992f2c68569f009c467fae53b69e9b268488f8f91ca1";
    public String user_id="411465182";

//    public String token = "1ad89e086d9203386caa96954e843be707d9415ed54451b04f6fbe2bdbb5d6ff41da64fa42ee3e54f5aa6";
//    public String user_id="144970652";


    public static void main(String[] args)throws InterruptedException{



        Testing tester = new Testing();

        while (true) {
            tester.setupClass();
            tester.setupTest();
            tester.test();
            tester.teardown();

            tester.setupClass();
            tester.setupTest();
            tester.testPartTwo();
            tester.teardown();
            Thread.sleep(300000);
        }
    }


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("2.35").setup();
    }
    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {

//        ############################
//        ########## qrfinex #########
//        ############################

        driver.get("https://qrfinex.com/stocks");
        driver.findElement(By.className("stock-preview__col-1"));
        WebElement stockPreview = driver.findElement(By.id("scrollable-auto-tab-3"));
        stockPreview.click();
        QRFinexText = driver.findElement(By.className("stock-preview__col-1")).getText();
//        System.out.println(driver.findElement(By.className("stock-preview__col-1")).getText());
        driver.close();
    }

    public void testPartTwo(){

//        ############################
//        #### vkontakte login #######
//        ############################

        if(!qrFinexArray.equals(QRFinexText)) {
            qrFinexArray = QRFinexText;
            Integer random_number2 = 10 + (int) (Math.random() * 1000);
            driver.get("https://api.vk.com/method/messages.send?user_id="+user_id+"&random_id="+random_number2+"&message="+qrFinexArray+"&access_token="+token+"&v=5.92");
        }
        driver.close();
    }


}
