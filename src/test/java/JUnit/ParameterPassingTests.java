package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterPassingTests {


    @ParameterizedTest
    //@ParameterizedTest(name="Run: {index} - value: {arguments}") // if we want to annotate method to pass simple value to it, we need this annotation
    @ValueSource(ints ={1,5,6}) // This annotation used to tell method which data type, how much value we pass and what value we pass to method
    // for multiple input we use array {,,,} and specify data type like ints boolean string
    void intValues(int theParams){
        System.out.println("The args are : "+theParams);
    }

    @ParameterizedTest(name="Run : {index} - value: {arguments}") // if we want to display customised method name for each run we use this (instead of [1]:1 [2]:5 [3]:6)
    @ValueSource(strings ={"Hello","World","of","God"}) // This annotation used to tell method which data type, how much value we pass and what value we pass to method
    // for multiple input we use array {,,,} and specify data type like ints boolean string
    void strValues(String theParams){
        System.out.println("The args are : "+theParams);
    }

    @ParameterizedTest(name="Run for empty and null : {index} - value: {arguments}")
    @NullSource //Passing null at starting only in String
    @EmptySource//Passing Empty at stating only in String
    // or @NullAndEmptySource
    @ValueSource(strings ={"Hello","World","of","God"}) // This annotation used to tell method which data type, how much value we pass and what value we pass to method
        // for multiple input we use array {,,,} and specify data type like ints boolean string
    void strValues1(String theParams){
        System.out.println("The args are : "+theParams);
    }


    @ParameterizedTest(name="Run : {index} - value: {arguments}")
    @CsvSource(value ={"steve,rogers", "captain,marvel", "bucky,barnes"}) // we are passing comma separated value
    void csvSource_StringString(String param1,String param2){
        System.out.println("FirstName = " + param1 + ", LastName = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve,62,true", "captain,21,false", "bucky,50,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("Name = " + param1 + ", Power = " + param2 + ", SuperHero = " + param3);
    }

    //if we wnt to pass comma along with string
    @ParameterizedTest
    @CsvSource(value={"Steve,'rogre,s'","winter ,"+"'solger,s'"})
    void csv_with_comma(String params1,String params2){
        System.out.println("FirstName = " + params1 + ", LastName = " + params2);
    }

    @ParameterizedTest
    @CsvSource(value ={"steve?rogers", "bucky?barnes"},delimiter = '?') // type of separated value line ?,$ % ect
    void csv_with_different_delimiter(String params1,String params2){
        System.out.println("FirstName = " + params1 + ", LastName = " + params2);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/ShoppingList.csv",numLinesToSkip = 1)//numLinesToSkip = 1 ,is used skip header in csv
    void csvFileSource_StringIntInt(String name,int price,int quantity){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/ShoppingList.csv","src/test/resources/params/ShoppingList2.csv"},numLinesToSkip = 1)//numLinesToSkip = 1 ,is used skip header in csv
    void csvFileSource_WithTwoFile_StringIntInt(String product,int price,int quantity){
        System.out.println("product = " + product + ", price = " + price + ", quantity = " + quantity);
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/ShoppingList3.csv",
            numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price,
                                                                     int qty, String uom,
                                                                     String provider) {
        System.out.println("name = " + name + ", price = " + price +
                ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    // in csv if we want empty string enter "" if we want null leave it blank

}
