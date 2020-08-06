package com.techproed.smoketest;

import com.techproed.pages.Day21_GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day21_GlbCategoryDropdownTest {
    @Test
    public void glbDropdownTest() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        Day21_GlbHomePage glbHomePage = new Day21_GlbHomePage();
        Select options = new Select(glbHomePage.allCategoriesDropdown);

        boolean flag = false;
        for (WebElement option : options.getOptions()){
            if (option.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardir.");
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);
        Driver.closeDriver();
    }
}
