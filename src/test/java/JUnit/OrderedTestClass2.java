package JUnit;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // @Order(...-5,-4,-3,-2,-1,0,1,2,3,4...)
// if no order is mentioned for some method the -integer max value % 2, so it will be large number
public class OrderedTestClass2 {
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
    @Order(-15)
    void firstMethod(){
        System.out.println("FirstTest method executed");
    }


    //@DisplayName is used to display String instead of firstMethod during execution in test execution hierarchy
    @Test
    void secondMethod(){System.out.println("SecondTest method executed");}

    @Test
    @DisplayName("a Fourth method")
//    @DisplayName("Using DisplayName annotations to set custom Name")
    void fourthMethod(){System.out.println("Fourth method executed");}

    @Test
    @Order(2)
    void thirdName(){
        System.out.println("ThirdTest method executed");
    }
}
