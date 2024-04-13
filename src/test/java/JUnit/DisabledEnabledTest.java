/*
Sometimes we need the option to disable the tests that we created.
Maybe it's because the test should not run on a specific day, because maybe during that day, there is an environment refresh, or maybe we simply don't want to run the tests on certain operating systems, or maybe on certain browsers.
 */

package JUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {
    @Test
    @Disabled(value="Disable for demo of @Disabled ") // we can run at ide with run button even with disable
    void firstMethod(){
        System.out.println("First Method Ran");
    }
    @Test
    @DisabledOnOs(value= OS.WINDOWS,disabledReason = "demo of @DisabledOnOs") // disable in particular OS
    void secondMethod(){
        System.out.println("Second Method Ran");
    }
    @Test
    @EnabledOnOs(value = OS.MAC)
    void thirdMethod(){
        System.out.println("Third Method Ran");
    }
    @Test
    // for this DisabledIfSystemProperty we need to set properties in run configurations
    // do this before running this in setting run->edit configuration removed all junit run add new with class selected and -Denv=IT
    @DisabledIfSystemProperty(named = "env",matches = "IT")
    void fourthMethod(){
        System.out.println("Fourth Method Ran");
    }
    @Test
    @DisabledIf(value="provider")
    void fifthMethod(){
        System.out.println("Fifth Method Ran");
    }
    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
