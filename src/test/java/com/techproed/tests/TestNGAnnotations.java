package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeClass // Sadece class'in basinda bir defa calisir.
    public void beforeClass(){
        System.out.println("=======Before Class=======");
    }
    @BeforeMethod //Her test methodundan önce calisir
    public void beforeMethod(){
        System.out.println("=======Before Methode=======");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("=======Before Test=======");
    }
    @Test
    public void test1 (){
        System.out.println("Bu Test1 Methodudur");
    }

    @Test
    public void test2(){
        System.out.println("Bu Test2 Methodudur");
    }

    @Ignore // @Ignore sadece @Test methodlarinda calisir. @Before, @After da calismaz.
    @Test
    public void test3(){
        System.out.println("Bu Test3 Methodudur");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("======After Method======");
    }
  @AfterClass// class'in sonunda sadece bir defa calisir
  public void afterClass(){
      System.out.println("======After Class======");
  }
  @AfterTest// class'in basinda bir defa calisir xml dosyalarinda kullanilir.
  public void afterTest(){
      System.out.println("======After Test======");
  }

}
