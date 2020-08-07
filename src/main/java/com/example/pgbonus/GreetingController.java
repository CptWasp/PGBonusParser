package com.example.pgbonus;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model model) {

        return "greeting";
    }




    @PostMapping("greeting")
    public String beginingApp(Map<String, Object> model) throws IOException, InterruptedException {

        System.out.println("POST активирован");

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
            Thread.sleep(60000);
        }



//        return "greeting";
    }

}