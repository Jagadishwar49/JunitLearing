package JUnit;

import org.junit.jupiter.api.*;
//@TestMethodOrder(MethodOrderer.MethodName.class) // runs @Test method with alphabetical order of method name
@TestMethodOrder(MethodOrderer.DisplayName.class) // runs @Test method with alphabetical order of @DisplayName value annotations name
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//When we use @BeforAll or @AfterAll method should be Static to avoid making static we use @TestInstance
public class OrderedTestClass {
    @BeforeAll
        // run this before anything run in this test cass
        //main used to initialise browser
    void beforeAll(){System.out.println("==========Before All========");
        System.out.println(" ");}

    @BeforeEach
// execute before Each @Test method
    void beforeEach(){System.out.println("----------Before Each--------");}

    @AfterAll
// run this before anything run in this test cass
        // main used to taredown like driver close
    void afterAll(){System.out.println("==========After All========");}

    @AfterEach
        // execute after Each @Test method
    void afterEach(){
        System.out.println("----------after Each--------");
        System.out.println(" ");
    }

    @Test
    void firstMethod(){
        System.out.println("FirstTest method executed");
    }

    //@DisplayName is used to display String instead of firstMethod during execution in test execution hierarchy
    @Test
    @DisplayName("DisplayName annotations to set custom Name")
    void secondMethod(){System.out.println("SecondTest method executed");}

    @Test
    void athirdName(){
        System.out.println("ThirdTest method executed");
    }
}
