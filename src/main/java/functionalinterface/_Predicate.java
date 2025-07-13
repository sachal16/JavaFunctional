package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        //Normal Java Method
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("070000000032432565"));
        System.out.println(isPhoneNumberValid("0900000000342243"));


        //Functional
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("070000000032432565"));
        System.out.println(isPhoneNumberValidPredicate.test("0900000000342243"));

       System.out.println(
               "Is phone number valid and contains 3 = " +
               isPhoneNumberValidPredicate.and(containsNumber3).test("0900987700")
       );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("07009877300")
        );

        System.out.println(
                "Is phone number valid and contains 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("07009877200")
        );
        System.out.println(
                isValidPhoneInCountry.test("09213342442313", "09")
        );


    }

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") || phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") || phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static BiPredicate<String,String> isValidPhoneInCountry = (phone, countryCode) ->
            phone.startsWith(countryCode) && phone.length() == 13;
}
