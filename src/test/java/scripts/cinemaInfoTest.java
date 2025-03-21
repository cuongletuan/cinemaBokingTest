package scripts;

import org.testng.annotations.*;

public class cinemaInfoTest {

    @BeforeClass
    public void classSetup(){
        System.out.println("Setup class Before Class");
    }

    @BeforeMethod
    public void setupTest(){
        System.out.println("Set up text Before Method");
    }

    @Test
    public void setTest1(){
        System.out.println("Output 1");
    }
    @Test
    public void setTest2() {
        System.out.println("Output 2");
    }

    @AfterMethod
    public void Out(){
        System.out.println("Out After Method");
    }

    @AfterClass
    public void outClass(){
        System.out.println("Out class After class");
    }
}
