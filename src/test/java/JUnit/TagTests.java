/*
This annotation tag will help us include or exclude tests from a test run that we want to perform.
we can assign tags to them, and the tag is nothing more than a string which will be assigned to the test through an annotation called a tag.
 */
package JUnit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagTests {
    @Test
    @Tag("reg1") //no null value and empty no ()&!|
    void firstMethod(){
        System.out.println("First Method Ran");
    }
    @Test
    @Tag("reg1")
    void secondMethod(){
        System.out.println("Second Method Ran");
    }
    @Test
    @Tag("reg1")
    @Tag("reg2")
    void thirdMethod(){
        System.out.println("Third Method Ran");
    }
    @Test
    @Tag("reg2")
    void fourthMethod(){
        System.out.println("Fourth Method Ran");
    }
    @Test
    @Tag("reg2")
    void fifthMethod(){
        System.out.println("Fifth Method Ran");
    }
}
