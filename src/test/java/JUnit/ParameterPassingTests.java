package JUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    // 💯 for multiple input we use array {,,,} and specify data type like ints boolean string
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

    // 💫 if we want to pass comma along with string
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

    // 💥 in csv if we want empty string enter "" if we want null leave it blank

    @ParameterizedTest
    @MethodSource(value="sourceStringAsStream") // pass which ever method we want in below method
    void methodSource_String(String vegetable){
        System.out.println("vegetable = " + vegetable);
    }
    //🐞 if they are in different class we need to make it as Static 🐞
    // @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    // package.method we need to pass
    List<String> sourceString(){
        //data processing
        return Arrays.asList("tomato","carrot","cabbage");
    }

    //we can also pass it as Stream or List od array
    Stream<String> sourceStringAsStream(){
        //data processing
        return Stream.of("Meat","Milk","egg");
    }

    //method pass both int and string at same method

    @ParameterizedTest
    @MethodSource(value="sourceStream_StringDouble") // pass which ever method we want in below method
    void methodSource_StringIntInt(String vegetable,int qty,int price){
        System.out.println("vegetable = " + vegetable + ", qty = " + qty + ", price = " + price);
    }
    List<Arguments> sourceList_StringIntInt(){
        return Arrays.asList(arguments("carrot",2,10), arguments("beetroot",4,18), arguments("potato",9,90));
    }

    Stream<Arguments> sourceStream_StringDouble() {
        //processing
        return Stream.of(arguments("meat", 2, 0),
                arguments("egg", 4, 5), arguments(
                        "milk", 7, 8));
    }

}
