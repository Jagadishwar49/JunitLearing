/*
JUnit 5's assumption features, which will allow us to skip either an entire test or parts of the test based on the conditions that we will provide to the so-called Assumptions.
conditions that can be evaluated into a boolean.
 */
package JUnit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {
    @ParameterizedTest
    @ValueSource(ints ={1,5,6}) // This annotation used to tell method which data type, how much value we pass and what value we pass to method
    void intValues(int theParams){
        Assumptions.assumeTrue(theParams>4);
        System.out.println("The args are : "+theParams);
    }

    @ParameterizedTest(name="Run : {index} - value: {arguments}")
    @CsvSource(value ={"steve,rogers", "captain,marvel", "bucky,barnes"}) // we are passing comma separated value
    void csvSource_StringString(String param1,String param2){
        Assumptions.assumeFalse(param1.equals("steve"),"We Printed this to show the custom error message"+param2);
        System.out.println("FirstName = " + param1 + ", LastName = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,62,true", "captain,21,false", "bucky,50,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        Assumptions.assumingThat(param2>49,()-> System.out.println("Assuming true so running this code /n"));
        System.out.println("Name = " + param1 + ", Power = " + param2 + ", SuperHero = " + param3);
    }
}
