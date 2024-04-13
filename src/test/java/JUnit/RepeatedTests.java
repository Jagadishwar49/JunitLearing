/*
Sometimes in our automation efforts, we need to be able to run the same code from within a test method several times.
In this case, using parameterized tests is not exactly the best option because we don't really need to pass in any parameter values.
So we are not going to use parameterized tests because we don't want to pass in some dummy values, just so we can repeat the test.
However, for such situations, we can use the @RepeatedTest annotation from JUnit.
 */
package JUnit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {
    @RepeatedTest(5)
    void firstMethod(){
        System.out.println("We are repeating the test");
    }
    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." +
            " Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondRepeatedMethod() {
        System.out.println("We are repeating a new test");
    }

    @RepeatedTest(3)
    void thirdMethod(RepetitionInfo repetitionInfo){
        System.out.println("repetitionInfo = " + repetitionInfo);
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition()==2,()-> System.out.println("Assuming that ran so Repetition is 2"));

    }
}
