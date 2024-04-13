package JUnit;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//When we use @BeforAll or @AfterAll method should be Static to avoid making static we use @TestInstance
public class FirstTest {

    @BeforeAll // run this before anything run in this test cass
    //main used to initialise browser
    void beforeAll(){System.out.println("==========Before All========");}

    @BeforeEach// execute before Each @Test method
    void beforeEach(){System.out.println("----------Before Each--------");}

    @AfterAll// run this before anything run in this test cass
    // main used to taredown like driver close
    void afterAll(){System.out.println("==========After All========");}

    @AfterEach // execute after Each @Test method
    void afterEach(){System.out.println("----------after Each--------");}

    @Test // if we don't mention @test then we don't have run button, or it will not execute  method when we execute class
    //<Access modifier> <returnType> methodName(arg1,arg2...){}
    // Junit Doesn't require access So we can ignore (It does not allow to add access modifier to mention)
    void firstMethod(){
        System.out.println("FirstTest method executed");
    }

    //@DisplayName is used to display String instead of firstMethod during execution in test execution hierarchy
    @Test
    @DisplayName("Using DisplayName annotations to set custom Name")
    void secondMethod(){System.out.println("SecondTest method executed");}
}
