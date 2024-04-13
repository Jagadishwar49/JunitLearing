package JUnit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssertionsTests {
    @Test
    void assertEqualsTest() {
        Assertions.assertEquals("firstString", "secondString", "The String " + "values were not equal");
    }
    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString",
                "secondString","thirdString");
        List<String> actualValues = Arrays.asList("firstString",
                "secondString");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 5, 3};
        int[] actualValues = {1, 2, 3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    //💥💥 very important in this assert will not fail at 1st assert, but it runs all and fail 💥💥
    void assertAllTest() {
        assertAll(
                () -> assertEquals("firstString", "secondString", "The String " +
                        "values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true"));
    }


    /*
    Although JUnit 5 offers a large variety of Assertions, sometimes we need some additional ones that we don't have in JUnit 5.
    For that, we can use some external assertion libraries and one of these is Hamcrest.
    ❤️‍🔥❤️‍🔥 One of the available options in Hamcrest is to do Assertions on collections, which means we can do Assertions for Lists or for Maps, or even for Arrays, if we want to.❤️‍🔥❤️‍🔥
     */



}
